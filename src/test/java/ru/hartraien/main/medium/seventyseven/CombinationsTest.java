package ru.hartraien.main.medium.seventyseven;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CombinationsTest
{

    public static Stream<Arguments> Combinations()
    {
        return Stream.of(
                Arguments.arguments( 4, 2, new int[][]{ { 1, 2 }, { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 3, 4 } } ),
                Arguments.arguments( 1, 1, new int[][]{ { 1 } } )
        );
    }

    @ParameterizedTest
    @MethodSource("Combinations")
    void combine( int n, int k, int[][] result )
    {
        //TODO
    }
}