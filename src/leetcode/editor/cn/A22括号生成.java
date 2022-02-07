package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A22括号生成 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<String> res = new A22括号生成().generateParenthesis(3);

        System.out.println((System.currentTimeMillis() - start) + "ms");
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        backtrack(0, 0, new char[2 * n], result);
        return result;
    }

    //track为当前选择的组合，left为组合中左括号数量，right为组合中右括号数量
    public void backtrack(int left, int right, char[] track, List<String> result) {
        if (left + right == track.length) {
            if (left == right) {
                result.add(new String(track));
            }
            return;
        }
        //如果左括号数量小于右括号数量，不合法
        if (left < right || left > track.length / 2) return;

        //选择左括号作为当前元素
        track[left + right] = '(';
        backtrack(left + 1, right, track, result);
        //选择右括号作为当前元素
        track[left + right] = ')';
        backtrack(left, right + 1, track, result);
    }

    public List<String> generateParenthesis1(int n) {
        List<List<String>> res = new LinkedList<>();
        res.add(new LinkedList<>(Arrays.asList("")));
        res.add(new LinkedList<>(Arrays.asList("()")));
        for (int i = 2; i <= n; i++) {
            List<String> tmp = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = res.get(j);
                List<String> str2 = res.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        String str = "(" + s1 + ")" + s2;
                        tmp.add(str);
                    }
                }
            }
            res.add(tmp);
        }
        return res.get(n);
    }
}
