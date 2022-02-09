package leetcode.editor.cn.entity;

public class Util {


    public static String toStr(Object obj) {
        if (obj != null) {
            String name = obj.getClass().getSimpleName();
            System.out.println("name=" + name);
            switch (name) {
                case "Int":
                case "Long":
                case "Short":
                    return String.valueOf(obj);
                case "String":
                default:
                    return obj.toString();
            }
        }
        return "";
    }

    public static String toStr(ListNode node) {
        return node != null ? node.toString() : "";
    }

    public static String toStr(TreeNode node) {
        return node != null ? node.toString() : "";
    }
}
