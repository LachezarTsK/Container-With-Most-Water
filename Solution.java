public class Solution {

    public int maxArea(int[] height) {

        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int maxArea = calculateArea(height, leftIndex, rightIndex);

        while (leftIndex < rightIndex) {

            if (height[leftIndex] <= height[rightIndex]) {
                int current = height[leftIndex];
                while (leftIndex < rightIndex && height[leftIndex] <= current) {
                    leftIndex++;
                }
                maxArea = Math.max(maxArea, calculateArea(height, leftIndex, rightIndex));
            } else {
                int current = height[rightIndex];
                while (leftIndex < rightIndex && height[rightIndex] <= current) {
                    rightIndex--;
                }
                maxArea = Math.max(maxArea, calculateArea(height, leftIndex, rightIndex));
            }
        }
        return maxArea;
    }

    public int calculateArea(int[] height, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            return 0;
        }
        return Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex);
    }
}
