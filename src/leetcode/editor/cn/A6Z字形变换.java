package leetcode.editor.cn;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A6Z字形变换 {

    public static void main(String[] args) {
        String res = new A6Z字形变换().convert("LDREOEIIECIHNTSG", 4);
        System.out.println(res);
        res = new A6Z字形变换().convert1("LDREOEIIECIHNTSG", 4);
        System.out.println(res);
        res = new A6Z字形变换().convert2("LDREOEIIECIHNTSG", 4);
        System.out.println(res);
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        int rowLen = 2 * numRows - 2;
        int colLen = (int) Math.round(Math.ceil(s.length() * 1.0 / rowLen));
//        System.out.println("rowLen=" + rowLen + ",colLen=" + colLen);
        char[][] arr = new char[rowLen][colLen];
        int index;
        for (int col = 0; col < colLen; col++) {
            for (int row = 0; row < rowLen; row++) {
                index = col * rowLen + row;
                if (index < s.length()) {
                    arr[row][col] = s.charAt(index);
                } else {
                    break;
                }
//                System.out.println("写入index=" + index + ",row=" + row + ",col=" + col + ",value=" + arr[row][col]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < colLen; col++) {
                sb.append(arr[row][col]);
//                System.out.println("前输出row=" + row + ",col=" + col + ",value=" + arr[row][col]);
                if (row != 0 && row != (numRows - 1)) {
                    sb.append(arr[rowLen - row][col]);
//                    System.out.println("后输出row=" + (rowLen - row) + ",col=" + col + ",value=" + arr[rowLen - row][col]);
                }
            }
        }
        return sb.toString().replace("\u0000", "");
    }


    public String convert2(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col + row < len; col += cycleLen) {
                sb.append(s.charAt(col + row));
                if (row != 0 && row != numRows - 1 && col + cycleLen - row < len)
                    sb.append(s.charAt(col + cycleLen - row));
            }
        }
        return sb.toString();
    }

    public String convert1(String s, int numRows) {
        if (numRows == 1) return s;
        int rowLen = 2 * numRows - 2;
        int colLen = (int) Math.round(Math.ceil(s.length() * 1.0 / rowLen));
        StringBuilder sb = new StringBuilder();
        int index;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < colLen; col++) {
                index = col * rowLen + row;
                if (index < s.length()) {
                    sb.append(s.charAt(index));
//                    System.out.println("前输出row=" + row + ",col=" + col + ",value=" + s.charAt(index));
                }
                if (row != 0 && row != (numRows - 1)) {
                    index = col * rowLen + (rowLen - row);
                    if (index < s.length()) {
                        sb.append(s.charAt(index));
//                        System.out.println("后输出row=" + (rowLen - row) + ",col=" + col + ",value=" + s.charAt(index));
                    }
                }
            }
        }
        return sb.toString();
    }


}
