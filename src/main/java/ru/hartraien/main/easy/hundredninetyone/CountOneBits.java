package ru.hartraien.main.easy.hundredninetyone;

public class CountOneBits {
    public static int hammingWeight(int n) {
        //lazy implementation
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}
