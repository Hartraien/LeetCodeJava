package ru.hartraien.main.medium.ninetyfour;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class StringInterleavedTest
{

    public static Stream<Arguments> Strings()
    {
        return Stream.of(
                Arguments.arguments( "aabcc", "dbbca", "aadbbcbcac", true )
        );
    }

    @ParameterizedTest
    @MethodSource("Strings")
    void isInterleave( String s1, String s2, String s3, boolean result )
    {
        Assertions.assertEquals( result, StringInterleaved.isInterleave( s1, s2, s3 ) );
    }
}