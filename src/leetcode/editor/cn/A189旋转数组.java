package leetcode.editor.cn;

import leetcode.editor.cn.util.Tool;

import java.util.Arrays;


/**
 * 189. 旋转数组
 * 难度
 * 中等
 * <p>
 * 826
 * <p>
 * 收藏
 * <p>
 * 分享
 * 切换为英文
 * 接收动态
 * 反馈
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class A189旋转数组 {


    public static void main(String[] args) {
        int[] arrs = Tool.getTest(8);
        Tool.costTime(() -> {
            new A189旋转数组().rotate1(arrs, 8);
            System.out.println(Arrays.toString(arrs));

        });
    }


    /**
     * 动画执行
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) return;
        if (k >= nums.length) k = k % nums.length;
        for (int i = 0; i < k; i++) {//旋转几次
            int lastIndex = nums.length - 1;
            int temp = nums[lastIndex];//最后一个放入临时变量
            for (int j = lastIndex; j > 0; j--) {//动画旋转
                nums[j] = nums[j - 1];//当前的值等于上一个
            }
            nums[0] = temp;//临时变量放入第一个位置
        }
    }

    /**
     * 优化 直接执行
     */
    public void rotate1(int[] nums, int k) {
        if (nums == null || nums.length < 2) return;
        if (k >= nums.length) k = k % nums.length;
        int[] temps = nums.clone();//放入临时变量
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temps[(nums.length - k + i) % nums.length];
        }
    }
}
