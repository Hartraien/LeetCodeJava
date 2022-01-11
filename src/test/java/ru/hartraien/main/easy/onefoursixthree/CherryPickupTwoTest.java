package ru.hartraien.main.easy.onefoursixthree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CherryPickupTwoTest
{

    public static Stream<Arguments> gridSource()
    {
        return Stream.of(
                Arguments.arguments( new int[][]{ { 3, 1, 1 }, { 2, 5, 1 }, { 1, 5, 5 }, { 2, 1, 1 } }, 24 ),
                Arguments.arguments( new int[][]{ { 1, 0, 0, 0, 0, 0, 1 }, { 2, 0, 0, 0, 0, 3, 0 }, { 2, 0, 9, 0, 0, 0, 0 }, { 0, 3, 0, 5, 4, 0, 0 }, { 1, 0, 2, 3, 0, 0, 6 } }, 28 )
        );
    }

    @ParameterizedTest
    @MethodSource("gridSource")
    void cherryPickup( int[][] grid, int expected )
    {
        CherryPickupTwo cherryPickupTwo = new CherryPickupTwo();
        Assertions.assertEquals( expected, cherryPickupTwo.cherryPickup( grid ) );
    }
}