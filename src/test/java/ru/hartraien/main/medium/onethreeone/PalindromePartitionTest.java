package ru.hartraien.main.medium.onethreeone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class PalindromePartitionTest
{

    public static Stream<Arguments> StringSource()
    {
        return Stream.of(
                Arguments.arguments( "aab", new String[][]{ { "a", "a", "b" }, { "aa", "b" } } )
        );
    }

    @ParameterizedTest
    @MethodSource("StringSource")
    void partition( String s, String[][] expectedArray )
    {
        List<List<String>> expected = new ArrayList<>();
        for ( var elem : expectedArray )
        {
            expected.add( new ArrayList<>( List.of( elem ) ) );
        }

        PalindromePartition palindromePartition = new PalindromePartition();

        var result = palindromePartition.partition( s );
        Assertions.assertTrue( expected.containsAll( result ) && result.containsAll( expected ) );
    }
}