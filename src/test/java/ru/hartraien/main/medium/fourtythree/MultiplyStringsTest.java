package ru.hartraien.main.medium.fourtythree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MultiplyStringsTest {

    public static Stream<Arguments> stringSource() {
        return Stream.of(
                Arguments.arguments("2", "3", "6"),
                Arguments.arguments("123", "456", "56088")
        );
    }

    @ParameterizedTest
    @MethodSource("stringSource")
    void multiplyStrings(String num1, String num2, String expected) {
        Assertions.assertEquals(expected, MultiplyStrings.multiplyStrings(num1, num2));
    }
}