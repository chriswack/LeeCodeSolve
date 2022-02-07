package leetcode.editor.cn;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * <p>
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A11盛最多水的容器 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int res = new A11盛最多水的容器().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(res);
        System.out.println(System.currentTimeMillis() - start + "ms");

    }


    public int maxArea(int[] height) {
        int res = 0;
        int curr;
        for (int l = 0; l < height.length - 1; l++) {
            for (int r = l + 1; r < height.length; r++) {
                res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            }
        }
        return res;
    }

    public int maxArea2(int[] height) {
        int res = 0, l = 0, r = height.length - 1;
        while (l < r) {
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

}
