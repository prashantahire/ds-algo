package leetecode.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class UnixPathResolution {

    public static void main(String ...args){
        System.out.println(buildCanonicalPath("/home/"));
        System.out.println(buildCanonicalPath("/../"));
        System.out.println(buildCanonicalPath("/home//foo/"));
        System.out.println(buildCanonicalPath("/a/./b/../../c/"));
        System.out.println(buildCanonicalPath("/a/../../b/../c//.//"));
        System.out.println(simpleSolution("/a//b////c/d//././/.."));
        System.out.println(simpleSolution("/.../"));
        System.out.println(simpleSolution("/..."));
    }

    public static String buildCanonicalPath(String s){
        if(s == null || s.equals("") || s.length() == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder("/");
        int dotCount = 0;
        boolean isTwoDots = false;
        for(int i=0; i<s.length(); i++){
            if((s.charAt(i) == '/' && dotCount == 2) || (s.charAt(i) == '.' && dotCount == 1 && i == s.length()-1)){
                String [] temp = sb.toString().split("/");
                if(temp.length > 1) {
                    int deleteIdx = sb.length() - temp[temp.length - 1].length()-1;
                    sb.delete(deleteIdx, sb.length());
                }else{
                    sb = new StringBuilder("/");
                }
                dotCount = 0;
            }else if(s.charAt(i) == '.'){
                dotCount++;
                if(i == s.length()-1 && dotCount > 2){
                    for (int j = 0; j < dotCount; j++)
                        sb.append('.');
                }
            }else if(s.charAt(i) == '/' && ((sb.length() > 0 && (sb.charAt(sb.length()-1) == '/')) || i == s.length()-1)){
                if(dotCount > 2) {
                    for (int j = 0; j < dotCount; j++)
                        sb.append('.');
                }
                dotCount = 0;
                continue;
            }else if(s.charAt(i) == '/' && i != s.length()-1){
                if(dotCount > 2) {
                    for (int j = 0; j < dotCount; j++)
                        sb.append('.');
                }
                sb.append('/');
                dotCount = 0;
            }else{
                if(dotCount > 0) {
                    for (int j = 0; j < dotCount; j++)
                        sb.append('.');
                }
                dotCount=0;
                sb.append(s.charAt(i));
            }
        }
        if(sb.length() > 1 && sb.charAt(sb.length()-1) == '/')
            sb.delete(sb.length()-1, sb.length());
        return sb.toString();
    }

    public static String simpleSolution(String s){
        StringBuilder res = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String[] vals = s.split("/");
        for(int i=0; i<vals.length; i++){
            if("".equals(vals[i]) || ".".equals(vals[i]));
            else if("..".equals(vals[i])) stack.pop();
            else stack.push(vals[i]);
        }
        while (!stack.isEmpty()) res.insert(0, "/"+stack.pop());
        if(res.length() == 0) res.insert(0, "/");
        return res.toString();
    }
}
