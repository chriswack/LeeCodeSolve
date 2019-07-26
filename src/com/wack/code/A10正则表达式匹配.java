package com.wack.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A10正则表达式匹配 {

    public static void main(String[] args) {
        System.out.println("s*bd*aad*".startsWith(""));
        System.out.println(subStr("s", 0));
        boolean res = new A10正则表达式匹配().isMatch("sssb", "s*b");
        System.out.println(res);
    }

    public boolean isMatch(String s, String p) {
        int index = p.indexOf("*");
        if (index > 0) {
            System.out.println(index);
            String pPre = p.substring(0, index - 1);//*前面除去match的匹配部分
            if (s.startsWith(pPre)) {//前面匹配成功
                s = s.substring(index - 1);//截取前面匹配部分
                String match = subStr(p, index - 1);//获取匹配部分
                while (s.startsWith(match)) {//匹配match字符
                    s = s.substring(1);//匹配成功截取新的字符
                }
                p = p.substring(index + 1);//截取p已匹配和*部分
                return isMatch(s, p);
            } else {
                return false;
            }
        } else if (index == -1) {
            boolean isMatch = s.equals(p);
            return isMatch;
        }
        return false;
    }

    private static String subStr(String s, int index) {
        if (index >= 0 && index < s.length()) {
            return s.substring(index, index + 1);
        } else {
            return "";
        }
    }

    /**
     * 获得减去最后一个字符的字符串
     *
     * @param s
     * @return
     */
    private static String after(String s) {
        if (s.length() > 0) {
            return s.substring(0, s.length() - 1);
        } else {
            return "";
        }
    }

    private static String last(String s) {
        if (s.length() > 0) {
            return s.substring(s.length() - 1);
        } else {
            return "";
        }
    }


}
