package ru.hartraien.main.medium.seventyone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SimplifyStringTest
{

    public static Stream<Arguments> PathsProducer()
    {
        return Stream.of(
                Arguments.arguments( "/home/", "/home" )
                , Arguments.arguments( "/../", "/" )
                , Arguments.arguments( "/home//foo/", "/home/foo" )
                , Arguments.arguments( "/a/./b/../../c/", "/c" )
                , Arguments.arguments( "/", "/" )
        );
    }

    @ParameterizedTest
    @MethodSource("PathsProducer")
    void simplifyPath( String path, String result )
    {
        SimplifyString simplifyString = new SimplifyString();
        Assertions.assertEquals( result, simplifyString.simplifyPath( path ) );
    }
}