package leetcode.editor.cn.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 树节点
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        List<String> vals = new ArrayList<>();
        getStr(this, vals);
        return Arrays.toString(vals.toArray());
    }

    private static void getStr(TreeNode node, List<String> vals) {
        if (node == null) return;
        getStr(node.left, vals);
        vals.add(String.valueOf(node.val));
        getStr(node.right, vals);
    }

    /**
     * 获得空格
     *
     * @param num 数量
     * @return 结果
     */
    private static String getSpace(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
