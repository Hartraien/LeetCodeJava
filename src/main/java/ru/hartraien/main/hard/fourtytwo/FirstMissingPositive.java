package ru.hartraien.main.hard.fourtytwo;

public class FirstMissingPositive {
    public static int firstMissingPositve(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n)
                nums[i] = n + 1;
        }

        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > n)
                continue;

            num -= 1;
            if (nums[num] > 0)
                nums[num] = -nums[num];
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                return i + 1;
        }

        return n + 1;
    }

    public static int firstMissingPositiveMove(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] < n + 1 && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i]-1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }

        return n + 1;
    }
}
