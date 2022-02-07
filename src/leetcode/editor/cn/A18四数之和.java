package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A18四数之和 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        List<List<Integer>> res = new A18四数之和().fourSum(new int[]{5, 5, 3, 5, 1, -5, -5, 1, -2}, 4);
        List<List<Integer>> res = new A18四数之和().fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11);
        System.out.println(Arrays.toString(res.toArray()));
        System.out.println(System.currentTimeMillis() - start + "ms");

    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (len < 4) return ans;
        Arrays.sort(nums); // 排序
        for (int l = 0; l < len - 3; l++) {//从小到大指针
            if (nums[l] + nums[l + 1] + nums[l + 2] + nums[l + 3] > target)
                break; // 如果当前数字大于target，则四数之和一定大于target，所以结束循环
            if (l > 0 && nums[l] == nums[l - 1]) continue;
            for (int r = len - 1; r > l && r >= 3; r--) {//从大到小指针
                if (nums[r] + nums[r - 1] + nums[r - 2] + nums[r - 3] < target)
                    break; // 如果当前数字小于target，则四数之和一定小于target，所以结束循环
                if (r < len - 1 && nums[r] == nums[r + 1]) continue;
//                System.out.println(l + "-" + r);
                int L = l + 1;//取出正数第二个数下标
                int R = r - 1;//取出倒数第二个数下标
                while (L < R) {//正数第二个数小于倒数第二个数
                    int curr = nums[l] + nums[L] + nums[R] + nums[r];
                    if (curr < target) L++;
                    else if (curr > target) R--;
                    else {
                        ans.add(Arrays.asList(nums[l], nums[L], nums[R], nums[r]));
                        while (L < R && nums[L] == nums[L + 1]) L++; // 去重
                        while (L < R && nums[R] == nums[R - 1]) R--; // 去重
                        L++;
                        R--;
                    }

                }
            }
        }
        return ans;
    }

}
