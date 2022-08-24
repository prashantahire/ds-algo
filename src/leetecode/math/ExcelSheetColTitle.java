package leetecode.math;
//https://leetcode.com/problems/excel-sheet-column-title/submissions/
public class ExcelSheetColTitle {

    public static void main(String ...args){
        ExcelSheetColTitle e = new ExcelSheetColTitle();
        System.out.println(e.convertToTitle(701));
        System.out.println(e.convertToTitle(901));
        System.out.println(e.convertToTitle(78));
        System.out.println(e.convertToTitle(1352));
    }
    public String convertToTitle(int n) {
        if(n<=0)
            return "";
        StringBuilder sb = new StringBuilder();
        convertToTitleRec(n, sb);
        return sb.toString();
    }

    private void convertToTitleRec(int n, StringBuilder sb){
        if(n <= 26){
            sb.append((char)('A'+n-1));
            return;
        }
        int rem = n%26;
        int div = n/26;
        if(rem == 0){
            div-=1;
            rem = 26;
        }

        convertToTitleRec(div, sb);
        sb.append((char)('A'+rem-1));
        return;
    }
}
