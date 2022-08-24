package leetecode.backtracking;

import java.util.Set;

public class PermutationSequence {
    
    public static void main(String ...args) {
        PermutationSequence ps = new PermutationSequence();
        System.out.println(ps.getPermutation(4, 3));
    }
    public String getPermutation(int n, int k) {
        StringBuilder sb= new StringBuilder();
        for(int i=1; i<=n;i++)
            sb.append(i);
        return permuteBt(new StringBuilder(), sb.toString(), new PermCounter(0), n, k);
    }
    
    private String permuteBt(StringBuilder sb, String ip, PermCounter pc, int n, int k) {
        if(sb.length() == n) {
            pc.cnt++;
            if(pc.cnt == k)
                return sb.toString();
            return null;
        }
        String kpm= null;
        for(int i=0; i<ip.length(); i++) {
            kpm = permuteBt(new StringBuilder(sb.toString() + ip.charAt(i)), ip.substring(0, i) + ip.substring(i + 1), pc, n, k);
            if(kpm != null)
                return kpm;
        }
        return kpm;
    }
    int l = 0;
    public String getPermutation2(int n, int k) {
        boolean vis[] = new boolean[n+1];
        return getPermutation2("",vis, n, k);
    }

    private String getPermutation2(String s, boolean vis[], int n, int k){
        if(s.length() >=n){
            l++;
            if(k==l)
                return s;
            return null;
        }
        String ans = null;
        for(int j=1; j<=n; j++){
            if(vis[j]) continue;
            vis[j] = true;
            ans = getPermutation2(s+j, vis, n, k);
            if(ans != null) return ans;
            vis[j] = false;
        }
        return ans;
    }
}
class PermCounter{
    int cnt;
    PermCounter(int n){
        cnt = n;
    }
}
