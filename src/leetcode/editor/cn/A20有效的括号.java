package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A20有效的括号 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        boolean isValid = new A20有效的括号().isValid("[()[]{}][()[]{}][()[]{}]");
//        boolean isValid = new A20有效的括号().isValid("){");

        System.out.println((System.currentTimeMillis() - start) + "ms");
        System.out.println(isValid);
    }


    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        if (s.length() % 2 != 0) return false;
        if (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            return isValid(s.replace("()", "").replace("[]", "").replace("{}", ""));
        }
        return false;
    }

    public boolean isValid2(String s) {
        if (s == null || s.length() == 0) return true;
        if (s.length() % 2 != 0) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> queue = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character cha = s.charAt(i);
            if (map.containsKey(cha)) {
                if (queue.size() == 0 || !map.get(cha).equals(queue.pop())) return false;
            } else {
                queue.push(cha);
                if (queue.size() >= (s.length() - i)) return false;

            }
        }
        return queue.isEmpty();
    }
}
