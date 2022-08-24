package sunny;

public class IsRotatedArraySorted {
    
    public static void main(String ...args) {
        int a[]= {1,2,3,4,5};
        System.out.println(isSorted(a));
        int a1[]= {2,3,4,5,1};
        System.out.println(isSorted(a1));
        int a2[]= {3,4,5,1,2};
        System.out.println(isSorted(a2));
        int a3[]= {3,4,5,1,2, 6, 8};
        System.out.println(isSorted(a3));
        int a4[]= {2,1,3};
        System.out.println(isSorted(a4));

    }
    public static boolean isSorted(int a[]) {
        if(a == null || a.length <= 2)
            return true;
        
        int i=0;
        while(i<a.length-1) {
            if(a[i]>a[i+1]) {
                break;
            }
            i++;
        }
        if(i==a.length-1)
            return true;
        int j=i+1;
        while(j<a.length-1) {
            if(a[j]>a[j+1] || a[j]>a[i])
                return false;
            j++;
        }
        return a[j] > a[i] ? false:true;
    }
}
