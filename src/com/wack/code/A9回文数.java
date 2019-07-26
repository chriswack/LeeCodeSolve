package com.wack.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A9回文数 {

    public static void main(String[] args) {
        boolean res = new A9回文数().isPalindrome3(10);
        System.out.println(res);
    }


    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        else if (x < 10) return true;
        List<Integer> list = new ArrayList<>();
        while (x > 0) {
            int pop = x % 10;
            x /= 10;
            list.add(pop);
        }
        //收缩
        for (int left = 0; left < list.size(); left++) {
            int right = list.size() - left - 1;
            if (left < right) {
                if (list.get(left) != list.get(right)) return false;
            } else {
                return true;
            }
        }
        //中心扩展
        int mid = list.size() / 2;
        boolean isOdd = list.size() % 2 == 0;
        int offset = 1;
        if (isOdd) {//偶数
            while (mid + offset <= list.size()) {
                if (list.get(mid - offset) != list.get(mid + offset - 1)) return false;
                offset++;
            }
        } else {//奇数
            while (mid + offset < list.size()) {
                if (list.get(mid - offset) != list.get(mid + offset)) return false;
                offset++;
            }
        }
        return true;
    }


    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        else if (x < 10) return true;
        String str = String.valueOf(x);
        for (int left = 0; left < str.length(); left++) {
            int right = str.length() - left - 1;
            if (left < right) {
                if (!str.substring(left, left + 1).equals(str.substring(right, right + 1))) return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean isPalindrome3(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        else if (x < 10) return true;
        int res = 0;
        while (x > res) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return x == res || x == res / 10;
    }
}
