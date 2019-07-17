package com.wack.code;

public class A5最长回文子串 {

    public static void main(String[] args) {
        String res = new A5最长回文子串().longestPalindrome("calsljghjek");
        System.out.println(res);
    }

    public String longestPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        sb.append("$#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        sb.append("@");
        int max = sb.length()-1;
        int[] p = new int[sb.length()];
        for (int i = 1; i < sb.length() - 1; i++) {

        }
        return "";
    }
}
