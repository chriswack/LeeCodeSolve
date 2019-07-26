package com.wack.code;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A5最长回文子串 {

    public static void main(String[] args) {
        String res = new A5最长回文子串().longestPalindrome("cwdadad");
        System.out.println(res);
    }

    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("$#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append("#");
        }
        sb.append("@");
        s = sb.toString();
        int max = 0;
        int index = 0;
        for (int i = 1; i < s.length() - 1; i++) {
            int curr = getOffset(s, i);
            if (max < curr) {
                max = curr;
                index = i;
            }
            if (s.length() <= max + i + 1) break;
        }
        max -= 1;
        return s.substring(index - max, index + max).replace("#", "");
    }

    private int getOffset(String str, int index) {
        int offset = 1;
        while (str.charAt(index - offset) == str.charAt(index + offset)) offset++;
        return offset;
    }

}
