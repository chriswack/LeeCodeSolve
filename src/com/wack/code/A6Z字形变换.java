package com.wack.code;

public class A6Z字形变换 {

    public static void main(String[] args) {
        String res = new A6Z字形变换().convert("LDREOEIIECIHNTSG", 4);
        System.out.println(res);
        res = new A6Z字形变换().convert1("LDREOEIIECIHNTSG", 4);
        System.out.println(res);
        System.out.println(Math.ceil(5 / 2));
    }

    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;

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


    public String convert1(String s, int numRows) {
        if (numRows <= 1) return s;
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
