package ru.hartraien.main.hard.twentythree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.hartraien.main.hard.twentyfive.ListNode;

import java.util.stream.Stream;


class MergeKListsTest
{

    private static Stream<Arguments> arraySource()
    {
        return Stream.of(
                Arguments.arguments( new int[][]{ { 1, 4, 5 }, { 1, 3, 4 }, { 2, 6 } }, new int[]{ 1, 1, 2, 3, 4, 4, 5, 6 } ),
                Arguments.arguments( new int[][]{ {} }, new int[]{} )
        );
    }

    @ParameterizedTest
    @MethodSource("arraySource")
    void mergeKListsFirst( int[][] array, int[] result )
    {
        ListNode[] lists = new ListNode[array.length];
        for ( int i = 0; i < array.length; i++ )
        {
            lists[i] = ListNode.build( array[i] );
        }
        ListNode expected = ListNode.build( result );
        Assertions.assertEquals( expected, MergeKLists.mergeKLists( lists ) );

    }
}