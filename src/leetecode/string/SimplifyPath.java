package leetecode.string;

import java.util.*;

public class SimplifyPath {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        String strs[] = path.split("/");
        for(String dir : strs){
            if(dir.equals("..") && !stack.isEmpty())
                stack.pop();
            else if(!skip.contains(dir))
                stack.push(dir);
        }
        List<String> list = new ArrayList<>(stack);
        return "/"+String.join("/", list);
    }
}
