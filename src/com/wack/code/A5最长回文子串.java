package com.wack.code;

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
