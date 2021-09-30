package ru.hartraien.main.easy.twohundredfive;

import java.util.Arrays;

public class StringIsomorphism {
    public static boolean isIsomorphic(String s, String t) {
        int[] seenInFirst = new int[256];
        int[] seenInSecond = new int[256];
        Arrays.fill(seenInFirst, -1);
        Arrays.fill(seenInSecond, -1);
        for (int i = 0; i < s.length(); i++) {
            int sChar = s.charAt(i);
            int tChar = t.charAt(i);
            if (seenInFirst[sChar] != seenInSecond[tChar])
                return false;
            seenInFirst[sChar] = i;
            seenInSecond[tChar] = i;
        }
        return true;
    }
}
