package ru.hartraien.main.hard.fourtytwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TrappingRainWaterTest {

    public static Stream<Arguments> arraySource() {
        return Stream.of(
                Arguments.arguments(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6),
                Arguments.arguments(new int[]{4, 2, 0, 3, 2, 5}, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("arraySource")
    void trap(int[] nums, int result) {
        Assertions.assertEquals(result, TrappingRainWater.trap(nums));
    }
}