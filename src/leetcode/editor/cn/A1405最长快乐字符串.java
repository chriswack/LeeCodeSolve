package leetcode.editor.cn;

import leetcode.editor.cn.util.Tool;

import java.util.Arrays;
import java.util.PriorityQueue;
//如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。 
//
// 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s： 
//
// 
// s 是一个尽可能长的快乐字符串。 
// s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。 
// s 中只含有 'a'、'b' 、'c' 三种字母。 
// 
//
// 如果不存在这样的字符串 s ，请返回一个空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 输入：a = 1, b = 1, c = 7
//输出："ccaccbcc"
//解释："ccbccacc" 也是一种正确答案。
// 
//
// 示例 2： 
//
// 输入：a = 2, b = 2, c = 1
//输出："aabbc"
// 
//
// 示例 3： 
//
// 输入：a = 7, b = 1, c = 0
//输出："aabaa"
//解释：这是该测试用例的唯一正确答案。 
//
// 示例 3：
//
// 输入：a = 5, b = 3, c = 4
//输出："aabbabaccacc"
//解释：这是该测试用例的唯一正确答案。
//
// 
//
// 提示： 
//
// 
// 0 <= a, b, c <= 100 
// a + b + c > 0 
// 
// Related Topics 贪心 字符串 堆（优先队列） 
// 👍 129 👎 0

public class A1405最长快乐字符串 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("输入=>");
        Tool.costTime(() -> {
            String result = solution.longestDiverseString(1, 1, 7);
            System.out.println("输出=>" + result);
        });
    }

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 数组数据排序
         * 贪心算法，每次拼接数据后进行排序，获取最多项的数据
         */
        public String longestDiverseString1(int a, int b, int c) {
            Part[] arr = {new Part(a, 'a'), new Part(b, 'b'), new Part(c, 'c')};
            int noZeroCount = 0;//为零判断
            for (Part part : arr) {
                if (part.len != 0) noZeroCount++;
            }
            StringBuilder sb = new StringBuilder();
            switch (noZeroCount) {
                case 0://都为空
                    return "";
                case 1://仅有一个不为空
                    Arrays.sort(arr, (p1, p2) -> p2.len - p1.len);
                    char cha = arr[0].ch;
                    sb.append(cha).append(cha);
                    return sb.toString();
                default://其他
                    while (true) {
                        Arrays.sort(arr, (p1, p2) -> p2.len - p1.len);
                        boolean hasNext = false;
                        for (Part part : arr) {
                            if (part.len <= 0) break;
                            int len = sb.length();
                            if (len >= 2 && sb.charAt(len - 2) == part.ch && sb.charAt(len - 1) == part.ch) {
                                continue;
                            }
                            hasNext = true;
                            sb.append(part.ch);
                            part.len--;
                            break;
                        }
                        if (!hasNext) break;//跳出while
                    }
                    return sb.toString();
            }
        }

        /**
         * 使用优先队列
         * 贪心算法，每次拼接数据后进行排序，获取最多项的数据
         */
        public String longestDiverseString(int a, int b, int c) {
            PriorityQueue<Part> queue = new PriorityQueue<>((p1, p2) -> p2.len - p1.len);
            if (a != 0) queue.add(new Part(a, 'a'));
            if (b != 0) queue.add(new Part(b, 'b'));
            if (c != 0) queue.add(new Part(c, 'c'));
            StringBuilder sb = new StringBuilder();
            while (!queue.isEmpty()) {
                Part part = queue.poll();
                int len = sb.length();
                //存在重复项
                if (len >= 2 && sb.charAt(len - 2) == part.ch && sb.charAt(len - 1) == part.ch) {
                    if (queue.isEmpty()) break;//不存在下一个 跳出
                    Part next = queue.poll();//取出下一个 拼接数据
                    queue.add(part);//放回当前项
                    part = next;//替换下一个数据

                }
                sb.append(part.ch);
                part.len--;
                if (part.len <= 0) continue;//无数据不再入栈
                queue.add(part);//不为空重复入栈
            }
            return sb.toString();
        }

        class Part {
            public int len;
            public char ch;

            public Part(int len, char ch) {
                this.len = len;
                this.ch = ch;
            }

            @Override
            public String toString() {
                return "Part{" +
                        "len=" + len +
                        ", ch=" + ch +
                        '}';
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
