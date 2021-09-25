package ru.hartraien.main.hard.twentyfive;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReverseNodesInKGroupTest
{
/*
[1,2,3,4,5]
3
[1,2,3,4,5]
1
[1]
1
 */


    @Test
    void reverseKGroupFirst()
    {
        int[] array = { 1, 2, 3, 4, 5 };
        int[] result = { 2, 1, 4, 3, 5 };
        int k = 2;

        ListNode input = ListNode.build( array );
        ListNode expected = ListNode.build( result );

        Assertions.assertEquals( expected, ReverseNodesInKGroup.reverseKGroup( input, k ) );
    }

    @Test
    void reverseKGroupSecond()
    {
        int[] array = { 1, 2, 3, 4, 5 };
        int[] result = { 3, 2, 1, 4, 5 };
        int k = 3;

        ListNode input = ListNode.build( array );
        ListNode expected = ListNode.build( result );

        Assertions.assertEquals( expected, ReverseNodesInKGroup.reverseKGroup( input, k ) );
    }

    @Test
    void reverseKGroupThird()
    {
        int[] array = { 1 };
        int[] result = { 1 };
        int k = 1;

        ListNode input = ListNode.build( array );
        ListNode expected = ListNode.build( result );

        Assertions.assertEquals( expected, ReverseNodesInKGroup.reverseKGroup( input, k ) );
    }
}