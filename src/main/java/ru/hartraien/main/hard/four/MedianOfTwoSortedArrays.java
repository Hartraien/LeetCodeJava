package ru.hartraien.main.hard.four;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return 0.0;

        if (nums1.length == 0)
            return median(nums2);
        else if (nums2.length == 0)
            return median(nums1);


        if (nums1.length > nums2.length)
            return finder(nums2, nums1);
        else
            return finder(nums1, nums2);
    }

    private static double median(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0.0;
        if (n == 1)
            return nums[0];

        if (n % 2 == 0)
            return (nums[n / 2] + nums[n / 2 - 1])/2.0;
        else
            return nums[n / 2];

    }


    private static double finder(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int start = 0;
        int end = n;
        int realMid = (n + m + 1) / 2;
        while (start <= end) {
            int mid = (start + end) / 2;
            int leftASize = mid;
            int leftBSize = realMid - mid;

            int leftA = (leftASize > 0) ? nums1[leftASize - 1] : Integer.MIN_VALUE;
            int leftB = (leftBSize > 0) ? nums2[leftBSize - 1] : Integer.MIN_VALUE;

            int rightA = (leftASize < n) ? nums1[leftASize] : Integer.MAX_VALUE;
            int rightB = (leftBSize < m) ? nums2[leftBSize] : Integer.MAX_VALUE;

            if (leftA <= rightB && leftB <= rightA) {
                if ((m + n) % 2 == 0)
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                else
                    return Math.max(leftA, leftB);
            } else if (leftA > rightB)
                end = mid - 1;
            else
                start = mid + 1;

        }
        return 0.0;
    }

}
