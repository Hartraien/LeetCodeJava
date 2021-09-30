package ru.hartraien.main.easy.twohundredfive;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class StringIsomorphismTest {

    public static Stream<Arguments> stringSource() {
        return Stream.of(
                Arguments.arguments("egg", "add", true),
                Arguments.arguments("foo", "bar", false),
                Arguments.arguments("paper", "title", true),
                Arguments.arguments("badc", "baba", false)
        );
    }

    @ParameterizedTest
    @MethodSource("stringSource")
    void isIsomorphic(String first, String second, boolean expected) {
        Assertions.assertEquals(expected, StringIsomorphism.isIsomorphic(first, second));
    }
}