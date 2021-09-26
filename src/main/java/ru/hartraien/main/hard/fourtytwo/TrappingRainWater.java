package ru.hartraien.main.hard.fourtytwo;

public class TrappingRainWater {
    public static int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int n = height.length;
        int maxLeft = 0;
        int maxRight = 0;
        int res = 0;

        int leftIndex = 0;
        int rightIndex = n - 1;
        while (leftIndex <= rightIndex) {
            if (height[leftIndex] <= height[rightIndex]) {
                if (maxLeft < height[leftIndex])
                    maxLeft = height[leftIndex];
                else
                    res = res + maxLeft - height[leftIndex];
                leftIndex += 1;
            } else {
                if (maxRight < height[rightIndex])
                    maxRight = height[rightIndex];
                else
                    res = res + maxRight - height[rightIndex];
                rightIndex -= 1;
            }
        }
        return res;
    }
}
