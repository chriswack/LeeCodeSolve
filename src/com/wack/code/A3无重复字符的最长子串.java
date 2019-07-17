package com.wack.code;

import java.util.HashMap;
import java.util.Map;

public class A3无重复字符的最长子串 {

    public static void main(String[] args) {
        String str = "asvdavc";
        System.out.println("length=" + lengthOfLongestSubstring2(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        char cha;
        while (max < s.length()) {
            for (int i = 0; i < s.length(); i++) {
                cha = s.charAt(i);
                if (!map.containsKey(cha)) {
                    map.put(cha, i);
                } else {
                    if (max < map.size()) max = map.size();
                    s = s.substring(map.get(cha) + 1);
                    map.clear();
                    break;
                }
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int max = 0;
        char cha;
        Map<Character, Integer> map = new HashMap<>();
        for (int index = 0, curr = 0; index < s.length(); index++) {
            cha = s.charAt(index);
            if (map.containsKey(cha)) {
                curr = Math.max(map.get(cha), curr);
            }
            max = Math.max(max, index - curr + 1);
            map.put(cha, index + 1);
        }
        return max;
    }
}
