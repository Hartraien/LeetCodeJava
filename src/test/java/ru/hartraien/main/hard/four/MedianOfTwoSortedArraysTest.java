package ru.hartraien.main.hard.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MedianOfTwoSortedArraysTest {

    public static Stream<Arguments> arraysSource() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 3}, new int[]{2}, 2.0),
                Arguments.arguments(new int[]{1, 2}, new int[]{3, 4}, 2.5),
                Arguments.arguments(new int[]{0, 0}, new int[]{0, 0}, 0.0),
                Arguments.arguments(new int[]{}, new int[]{1}, 1.0),
                Arguments.arguments(new int[]{2}, new int[]{}, 2.0),
                Arguments.arguments(new int[]{}, new int[]{2, 3}, 2.5),
                Arguments.arguments(new int[]{4}, new int[]{1, 2, 3, 5, 6}, 3.5)
        );
    }

    @ParameterizedTest
    @MethodSource("arraysSource")
    void findMedianSortedArrays(int[] nums1, int[] nums2, double expected) {
        Assertions.assertEquals(expected, MedianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
    }
}