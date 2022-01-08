package ru.hartraien.main.medium.seventynine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class WordSearchInGridTest
{

    public static Stream<Arguments> GridAndStringSource()
    {
        return Stream.of(
                Arguments.arguments( new char[][]{ { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCB", false )
        );
    }

    @ParameterizedTest
    @MethodSource("GridAndStringSource")
    void exist( char[][] board, String word, boolean expected )
    {
        WordSearchInGrid wordSearchInGrid = new WordSearchInGrid();
        Assertions.assertEquals( expected, wordSearchInGrid.exist( board, word ) );
    }
}