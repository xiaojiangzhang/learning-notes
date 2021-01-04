package leetcode.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Remove_K_digits {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        Deque<Character> stack = new LinkedList<>();

        int remain = num.length() - k;
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > num.charAt(i)  ) {
                stack.pollLast();
                k --;

            }
            stack.offerLast(num.charAt(i));
        }

        int ans = 0;
        for (int i = 0; i < stack.size(); i++){

                System.out.println(stack.pollFirst());


        }
        System.out.println(ans);
    }
}
