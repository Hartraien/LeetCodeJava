package ru.hartraien.main.easy.twohundredtwo;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static boolean happyNumber(int n) {
        if (n == 1)
            return true;
        Set<Integer> seen = new HashSet<>();
        while (!seen.contains(n)) {
            if (n == 1)
                return true;
            seen.add(n);
            int sumDigitSquares = 0;
            while (n != 0) {
                int temp = n % 10;
                sumDigitSquares += temp * temp;
                n /= 10;
            }
            n = sumDigitSquares;
        }

        return false;
    }
}
