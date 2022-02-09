package leetcode.editor.cn;

import leetcode.editor.cn.util.Tool;

import java.util.HashMap;
import java.util.Map;
//给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，满足 i < j 且 |nums[i] - nums[j]| == k 。
// 
//
// |x| 的值定义为： 
//
// 
// 如果 x >= 0 ，那么值为 x 。 
// 如果 x < 0 ，那么值为 -x 。 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,2,1], k = 1
//输出：4
//解释：差的绝对值为 1 的数对为：
//- [1,2,2,1]
//- [1,2,2,1]
//- [1,2,2,1]
//- [1,2,2,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,3], k = 3
//输出：0
//解释：没有任何数对差的绝对值为 3 。
// 
//
// 示例 3： 
//
// 输入：nums = [3,2,1,5,4], k = 2
//输出：3
//解释：差的绝对值为 2 的数对为：
//- [3,2,1,5,4]
//- [3,2,1,5,4]
//- [3,2,1,5,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 1 <= k <= 99 
// 
// Related Topics 数组 哈希表 计数 
// 👍 51 👎 0

public class A2006差的绝对值为K的数对数目 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.countKDifference(new int[]{1, 2, 2, 1}, 1);
        System.out.println("输入=>");
        Tool.costTime(() -> {

            System.out.println("输出=>" + result);
        });
    }

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countKDifference2(int[] nums, int k) {
            int count = 0;
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    int diff = nums[i] - nums[j];
                    if (diff == k || diff == -k) count++;
                }
            }
            return count;
        }

        public int countKDifference(int[] nums, int k) {
            int res = 0;
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                res += cnt.getOrDefault(nums[i] - k, 0) + cnt.getOrDefault(nums[i] + k, 0);
                cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
