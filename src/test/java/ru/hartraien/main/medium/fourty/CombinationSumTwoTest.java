package ru.hartraien.main.medium.fourty;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class CombinationSumTwoTest {


    public static Stream<Arguments> candidatesSource() {
        return Stream.of(
                Arguments.arguments(new int[]{10, 1, 2, 7, 6, 1, 5}, 8, new int[][]{
                        {1, 1, 6}, {1, 2, 5}, {1, 7}, {2, 6}
                }),
                Arguments.arguments(new int[]{2, 5, 2, 1, 2}, 5, new int[][]{{1, 2, 2}, {5}})
        );
    }

    @ParameterizedTest
    @MethodSource("candidatesSource")
    void combinationSum2(int[] candidates, int target, int[][] expectedArray) {
        List<List<Integer>> expected = new ArrayList<>();
        for (int[] elem : expectedArray) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (var member : elem)
                temp.add(member);
            expected.add(temp);
        }

        var result = CombinationSumTwo.combinationSum2(candidates, target);

        Assertions.assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }
}