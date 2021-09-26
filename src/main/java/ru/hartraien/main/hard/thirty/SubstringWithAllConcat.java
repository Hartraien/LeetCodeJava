package ru.hartraien.main.hard.thirty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithAllConcat {
    public static List<Integer> findSubstring(String s, String[] words) {
        final List<Integer> result = new ArrayList<>();
        if (words.length == 0)
            return result;
        final Map<String, Integer> count = new HashMap<>();
        for (final var elem : words) {
            count.put(elem, count.getOrDefault(elem, 0) + 1);
        }
        final int stringLength = s.length();
        final int wordLength = words[0].length();
        final int wordCount = words.length;

        for (int i = 0; i < stringLength - wordCount * wordLength + 1; i++) {
            final Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < wordCount) {
                final String word = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                if (count.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > count.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == wordCount)
                result.add(i);
        }
        return result;
    }

}
