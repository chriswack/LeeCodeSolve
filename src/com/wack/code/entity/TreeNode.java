package com.wack.code.entity;

/**
 * 树节点
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public String val;

    public TreeNode(String val) {
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

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
