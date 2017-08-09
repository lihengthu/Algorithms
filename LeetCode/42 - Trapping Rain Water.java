Analysis: 
    1. Two Pointers
    2. Stack

Solutions:

1. Two Pointers -- 
public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int max = 0;
        while (left <= right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if (leftMax < rightMax){
                max += leftMax - height[left];
                ++left;
            } else {
                max += rightMax - height[right];
                --right;
            }
        }
        return max;
    }
}
//思路一致，细节略有不同
public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int area = 0, secHight = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                secHight = Math.max(height[left], secHight);
                area += secHight - height[left];
                left++;
            } else {
                secHight = Math.max(height[right], secHight);
                area += secHight - height[right];
                right--;
            }
        }
        return area;
    }
}

//最简洁版本：
https://discuss.leetcode.com/topic/7612/java-10-lines-accepted-code-o-n-time-o-1-space-is-there-a-better-solution

2. Stack -- 待看
https://discuss.leetcode.com/topic/4939/a-stack-based-solution-for-reference-inspired-by-histogram/2