package ru.hartraien.main.medium.fourtyfive;

public class JumpGameTwo {

    public static int jump(int[] nums) {
        int jumps = 0;
        int curEnd = 0;
        int curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (curFarthest >= nums.length - 1)
                return jumps + 1;
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
