package ru.hartraien.main.hard.thirty;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SubstringWithAllConcatTest {

    public static Stream<Arguments> stringSource() {
        return Stream.of(
                Arguments.arguments("barfoothefoobarman"
                        , new String[]{"foo", "bar"}, new ArrayList<>(Arrays.asList(0, 9))),
                Arguments.arguments("wordgoodgoodgoodbestword",
                        new String[]{"word", "good", "best", "word"}, new ArrayList<Integer>()),
                Arguments.arguments("barfoofoobarthefoobarman",
                        new String[]{"bar", "foo", "the"}, new ArrayList<>(Arrays.asList(6, 9, 12))),
                Arguments.arguments("wordgoodgoodgoodbestword",
                        new String[]{"word", "good", "best", "good"}, new ArrayList<>(Arrays.asList(8)))
        );
    }

    @ParameterizedTest
    @MethodSource("stringSource")
    void findSubstring(String input, String[] words, List<Integer> answer) {
        Assertions.assertEquals(answer.stream().sorted().collect(Collectors.toList()),
                SubstringWithAllConcat.findSubstring(input, words).stream().sorted().collect(Collectors.toList()));
    }
}