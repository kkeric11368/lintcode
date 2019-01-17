//Given n non-negative integers representing an elevation map where the width of each bar is 1, 
//compute how much water it is able to trap after raining.

//https://lintcode-media.s3.amazonaws.com/problem/rainwatertrap.png

//Example
//Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

//Challenge
//O(n) time and O(1) memory
//O(n) time and O(n) memory is also acceptable.




public class Solution {
    public int trapRainWater(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        
        int water = 0;
        int sum = 0;
        
        for (int i = 0; i < height.length; i++) {
            water = Math.min(leftMax[i], rightMax[i]) - height[i];
            sum += water;
        }
        return sum;
    }    
}



