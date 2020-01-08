package com.wack.code;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A17电话号码的字母组合 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<String> res = new A17电话号码的字母组合().letterCombinations("12345");
        System.out.println(res);
        System.out.println(System.currentTimeMillis() - start + "ms");

    }

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};


    public List<String> letterCombinations(String digits) {
        List<String> answers = new LinkedList<>();
        if (digits.isEmpty()) {
            return answers;
        }
        backtrack(answers, "", digits);
        return answers;
    }


    public void backtrack(List<String> answers, String combination, String next_digits) {
        if (next_digits.length() == 0) {
            answers.add(combination);
        } else {
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                backtrack(answers, combination + letter, next_digits.substring(1));
            }
        }
    }

}
