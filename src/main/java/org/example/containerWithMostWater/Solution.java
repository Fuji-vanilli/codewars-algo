package org.example.containerWithMostWater;

public class Solution {

    public int maxArea(int[] height) {
        int maxArea= 0, left= 0, right= height.length-1;

        while (left< right) {
            int currentArea= Math.min(height[left], height[right])* (right- left);
            maxArea= Math.max(currentArea, maxArea);

            if ((height[left] < height[right])) {
                left++;
            } else {
                right--;
            }

        }

        return maxArea;
    }
}
