package walmart;

public class SearchRotatedPosition {
    public static void main(String args[] ) throws Exception {
        int num[] = new int[]{500,600,700,800,50, 100,200,300};
        int num2[] = { 1, 2, 3, 4, 5};
        System.out.println(getPositionRotatedPosition(num));
        System.out.println(getPositionRotatedPosition(num2));
    }

    public static int getPositionRotatedPosition(int a[]){
        if(a == null || a.length == 0){
            return -1;
        }
        return searchPostion(a, 0, a.length-1);
    }

    private static int searchPostion(int a[], int i, int j){
        int mid = (i+j)/2;
        if(i>j){
            return -1;
        }
        if(mid < a.length-1 && a[mid] > a[mid+1]){
            return mid;
        }else if(mid > 0 && a[mid] < a[mid-1]){
            return mid-1;
        }
        if(a[i] < a[mid] )
            return searchPostion(a,mid+1, j);
        if(a[mid] < a[j])
            return searchPostion(a, i, mid-1);

        int pos1 = searchPostion(a, i, mid-1);
        if(pos1 != -1)
            return pos1;
        return searchPostion(a, mid+1, j);
    }

}
