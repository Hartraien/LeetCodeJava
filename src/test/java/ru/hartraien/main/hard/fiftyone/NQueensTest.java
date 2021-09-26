package ru.hartraien.main.hard.fiftyone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class NQueensTest {

    public static Stream<Arguments> intSource() {
        return Stream.of(
                Arguments.arguments(4, new String[][]{
                        {".Q..", "...Q", "Q...", "..Q."}, {"..Q.", "Q...", "...Q", ".Q.."}
                }),
                Arguments.arguments(1, new String[][]{{"Q"}})
        );
    }

    @ParameterizedTest
    @MethodSource("intSource")
    void nQueens(int n, String[][] expectedArray) {
        List<List<String>> result = NQueens.solveNQueens(n);
        List<List<String>> expected = new ArrayList<>(expectedArray.length);
        for (var elem : expectedArray)
            expected.add(Arrays.asList(elem));

        //expected = expected.stream().sorted().collect(Collectors.toList());
        //result = result.stream().sorted().collect(Collectors.toList());

        Assertions.assertEquals(expected.size(), result.size());
        for (List<String> strings : expected) {
            Assertions.assertTrue(result.contains(strings));
        }
    }
}