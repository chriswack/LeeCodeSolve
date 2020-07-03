package com.wack.code;

import com.wack.code.entity.TreeNode;
import com.wack.code.entity.Util;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A108将有序数组转换为二叉搜索树 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        TreeNode treeNode = new A108将有序数组转换为二叉搜索树().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println((System.currentTimeMillis() - start) + "ms");
        System.out.println(Util.toStr(treeNode));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return getNode(nums, 0, nums.length - 1);
    }

    public TreeNode getNode(int[] nums, int start, int end) {
        if (end < start) return null;
        if (end == start) return new TreeNode(nums[start]);
//        int mid = (start + end + 1) / 2;//左树优先
        int mid = (start + end) / 2;//右树优先
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = getNode(nums, start, mid - 1);
        treeNode.right = getNode(nums, mid + 1, end);
        return treeNode;
    }
}
