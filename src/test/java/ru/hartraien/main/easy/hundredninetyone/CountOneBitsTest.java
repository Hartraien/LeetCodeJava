package ru.hartraien.main.easy.hundredninetyone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.hartraien.main.easy.hundredninetyone.CountOneBits;

import java.util.stream.Stream;

class CountOneBitsTest {

    public static Stream<Arguments> intSource() {
        return Stream.of(
                Arguments.arguments(0b00000000000000000000000000001011, 3),
                Arguments.arguments(0b00000000000000000000000010000000, 1),
                Arguments.arguments(0b11111111111111111111111111111101, 31)
        );
    }

    @ParameterizedTest
    @MethodSource("intSource")
    void hammingWeight(int input, int expected) {
        Assertions.assertEquals(expected, CountOneBits.hammingWeight(input));
    }
}