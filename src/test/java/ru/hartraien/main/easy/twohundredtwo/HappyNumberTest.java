package ru.hartraien.main.easy.twohundredtwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class HappyNumberTest {

    public static Stream<Arguments> intSource() {
        return Stream.of(
                Arguments.arguments(19, true),
                Arguments.arguments(2, false),
                Arguments.arguments(1, true)
        );
    }

    @ParameterizedTest
    @MethodSource("intSource")
    void happyNumber(int input, boolean expected) {
        Assertions.assertEquals(expected, HappyNumber.happyNumber(input));
    }
}