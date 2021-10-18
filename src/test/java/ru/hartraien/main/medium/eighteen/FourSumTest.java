package ru.hartraien.main.medium.eighteen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FourSumTest
{

    public static Stream<Arguments> NumsArray()
    {
        return Stream.of(
                Arguments.arguments( new int[]{ 1, 0, -1, 0, -2, 2 }, 0,
                        Arrays.stream(
                                new int[][]{ { -2, -1, 1, 2 }, { -2, 0, 0, 2 }, { -1, 0, 0, 1 } }
                        ).map( i -> Arrays.stream( i ).boxed().collect( Collectors.toList() ) ).collect( Collectors.toList() )
                ),
                Arguments.arguments( new int[]{ 2, 2, 2, 2, 2 }, 8,
                        Arrays.stream(
                                new int[][]{ { 2, 2, 2, 2 } }
                        ).map( i -> Arrays.stream( i ).boxed().collect( Collectors.toList() ) ).collect( Collectors.toList() )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("NumsArray")
    void fourSum( int[] nums, int target, List<List<Integer>> expected )
    {
        FourSum summer = new FourSum();
        Assertions.assertEquals( expected, summer.fourSum( nums, target ) );
    }
}