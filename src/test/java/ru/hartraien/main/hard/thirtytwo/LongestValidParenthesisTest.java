package ru.hartraien.main.hard.thirtytwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LongestValidParenthesisTest {

    public static Stream<Arguments> stringSource() {
        return Stream.of(
                Arguments.arguments("(()", 2),
                Arguments.arguments(")()())", 4),
                Arguments.arguments("", 0),
                Arguments.arguments("()", 2),
                Arguments.arguments("(())", 4),
                Arguments.arguments("()()", 4)
        );
    }

    @ParameterizedTest
    @MethodSource("stringSource")
    void longestValidParenthesisStack(String s, int result) {
        Assertions.assertEquals(result, LongestValidParenthesis.longestValidParenthesisStack(s));
    }
}