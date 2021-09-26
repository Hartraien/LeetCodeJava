package ru.hartraien.main.hard.thirtytwo;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParenthesis {
    public static int longestValidParenthesisStack(String s) {
        if (s.isEmpty())
            return 0;
        Deque<Integer> stack = new ArrayDeque<Integer>(s.length());
        char[] S = s.toCharArray();
        int maxLength = 0;

        for (int i = 0; i < S.length; i++) {
            if (S[i] == '(')
                stack.push(i);
            else {
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    if (S[stack.peek()] == '(') {
                        stack.pop();
                        maxLength = Math.max(maxLength, (i - ((stack.isEmpty()) ? -1 : stack.peek())));
                    } else {
                        stack.push(i);
                    }
                }
            }
        }
        return maxLength;
    }
}
