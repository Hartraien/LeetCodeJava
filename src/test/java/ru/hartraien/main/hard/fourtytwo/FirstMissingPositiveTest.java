package ru.hartraien.main.hard.fourtytwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FirstMissingPositiveTest {

    public static Stream<Arguments> numsSource() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 0}, 3),
                Arguments.arguments(new int[]{3, 4, -1, 1}, 2),
                Arguments.arguments(new int[]{7, 8, 9, 11, 12}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("numsSource")
    void firstMissingPositve(int[] nums, int result) {
        Assertions.assertEquals(result, FirstMissingPositive.firstMissingPositve(nums));
    }

    @ParameterizedTest
    @MethodSource("numsSource")
    void firstMissingPositveMove(int[] nums, int result) {
        Assertions.assertEquals(result, FirstMissingPositive.firstMissingPositiveMove(nums));
    }
}