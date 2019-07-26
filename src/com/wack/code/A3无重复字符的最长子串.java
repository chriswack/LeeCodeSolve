package com.wack.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
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
