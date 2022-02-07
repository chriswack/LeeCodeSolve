package leetcode.editor.cn;

/**
 * New
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class A14最长公共前缀 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String res = new A14最长公共前缀().longestCommonPrefix(new String[]{"a","a"});
        System.out.println(res);
        System.out.println(System.currentTimeMillis() - start + "ms");

    }


    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int curr = 0;
        char cha = 0;
        while (true) {
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() > curr) {
                    if (i == 0) {
                        cha = strs[i].charAt(curr);
                    } else {
                        if (strs[i].charAt(curr) != cha) {
                            return strs[i].substring(0, curr);
                        }
                    }
                } else {
                    return strs[i].substring(0, curr);
                }
            }
            curr++;
        }
    }


}
