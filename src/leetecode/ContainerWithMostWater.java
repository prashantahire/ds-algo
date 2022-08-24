package leetecode;

public class ContainerWithMostWater {
    
    public static void main(String ...args) {
        ContainerWithMostWater cw = new ContainerWithMostWater();
        int a[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(cw.maxArea(a));
        System.out.println(cw.maxAreaOptimized(a));
    }
    public int maxArea(int[] height) {
        if(height == null || height.length == 1)
            return 0;
        
        int maxArea = 0;
        for(int i=0; i< height.length; i++) {
            for(int j=i+1; j< height.length; j++) {
                int min = Math.min(height[i], height[j]);
                int area = min*(j-i);
                if(maxArea < area)
                    maxArea = area;
            }
        }
        return maxArea;
    }
    
    public int maxAreaOptimized(int[] height) {
        int l = 0, r = height.length-1;
        int maxArea = 0;
        while(l<r) {
            maxArea = Math.max(maxArea, (r-l)*Math.min(height[r], height[l]));
            if(height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxArea;
    }

    public int maxAreaOptimized2(int[] height) {
        int maxi = 0;
        int ma = 0;
        int i=1;
        while (i<height.length){
            int size = Math.min(height[i], height[maxi])*(i-maxi);
            if(size>ma)
                ma = size;
            if(height[i] > height[maxi])
                maxi = i;
            i++;
        }
        return ma;
    }
}
