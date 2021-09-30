package ru.hartraien.main.easy.hundredninety;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.hartraien.main.easy.hundredninety.ReverseBits;

import java.util.stream.Stream;

class ReverseBitsTest {

    public static Stream<Arguments> numberSource() {
        return Stream.of(
                Arguments.arguments(1, 1 << 31),
                Arguments.arguments(0b00000010100101000001111010011100, 0b00111001011110000010100101000000),
                Arguments.arguments(0b11111111111111111111111111111101, 0b10111111111111111111111111111111)
        );
    }

    @ParameterizedTest
    @MethodSource("numberSource")
    void reverseBits(int input, int expected) {
        Assertions.assertEquals(expected, ReverseBits.reverseBits(input));
    }
}