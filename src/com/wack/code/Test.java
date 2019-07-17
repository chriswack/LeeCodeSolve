package com.wack.code;

public class Test {
    public static void main(String[] args) {
String str = "85 01 02 45 00 02 00 01 02 0c 16 01 16 00 16 00 16 00 01 00 0a 07 44 4c 43 4a 2e 48 41 0a 04 43 41 52 41 0a 04 43 41 52 44 09 04 30 30 30 30 12 00 00 11 7b 12 00 f0 00 00";
        System.out.println(str.replace(" ","").substring(0,7*2)+str.replace(" ","").substring(8*2,19*2));
        System.out.println(""+toHexString("DLCJ.HA".getBytes()));
    }
//85 01 02 45 00 02 00    02 0c 16 01 16 00 16 00 16 00 01
//85 01 02 45 00 02 00 01 02 0c 16 01 16 00 16 00 16 00 01 00 0a 07 44 4c 43 4a 2e 48 41 0a 04 43 41 52 41 0a 04 43 41 52 44 09 04 30 30 30 30 12 00 00 11 7b 12 00 f0 00 00
    private static String handleAddr(String addr) {
        if (addr != null && addr.length() == 9) {
            String head = addr.substring(0, 4);
            String res = decToHex(addr.substring(4, 9));
            while (res.length() < 4) {
                res = "0" + res;
            }
            return head + res;
        }
        return addr;
    }

    private static String decToHex(String str) {
        int n = Integer.valueOf(str);
        StringBuilder sb = new StringBuilder(8);
        String a;
        char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (n != 0) {
            sb = sb.append(b[n % 16]);
            n = n / 16;
        }
        a = sb.reverse().toString();
        return a;
    }
    /**
     * 将byte值转化为HEX字符串
     *
     * @param value 带转化值
     * @return 转化后的HEX字符串-正确 null-错误
     */
    private static String toHexString(byte value) {
        String tmp = Integer.toHexString(value & 0xFF);
        /*
        为保证返回的字符串能够正确转化为byte数组
        保证字符串长度为2的倍数
         */
        return tmp.length() % 2 == 1 ? "0" + tmp : tmp;
    }

    public static String toHexString(byte[] values) {
        return toHexString(values, 0, values.length);
    }

    /**
     * 将byte数组转化为HEX字符串
     *
     * @param value  带转化byte数组
     * @param offset 数组开始位置
     * @param length 解析长度
     * @return 转化后的字符串-正确 null-错误
     */
    private static String toHexString(byte[] value, int offset, int length) {
        /*
        确保带转化数组有效
        确保传入的数组位置和长度信息没有越界
         */
        if (value == null || offset < 0 || length < 0 || offset + length > value.length) {
            return null;
        }

        StringBuilder retBuffer = new StringBuilder();

        for (int i = offset; i < offset + length; i++) {
            retBuffer.append(toHexString(value[i]));
        }

        return retBuffer.toString();
    }
}
