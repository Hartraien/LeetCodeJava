package ru.hartraien.main.medium.fourty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwo {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private static void dfs(int[] candidates, int start, int target, List<Integer> templist, List<List<Integer>> result) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList<>(templist));
        } else {
            for (int j = start; j < candidates.length; j++) {
                if (j > start && candidates[j] == candidates[j - 1])
                    continue;
                templist.add(candidates[j]);
                dfs(candidates, j + 1, target - candidates[j], templist, result);
                templist.remove(templist.size() - 1);
            }
        }
    }
}
