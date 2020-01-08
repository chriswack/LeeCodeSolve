package com.wack.code;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {


        List<String> strs = new ArrayList();
        strs.add(null);
        strs.add(null);
        strs.add(null);
        strs.add(null);
        System.out.println(strs.size());

    }


    private static String handleDecimal(String str) {
        int decimal = 3;
        if (decimal > 0) {
            if (str.contains(".")) {
                String data = str.substring(str.indexOf(".") + 1);
                if (data.length() < decimal) {
                    StringBuilder sb = new StringBuilder(str);
                    for (int i = 0; i < decimal - data.length(); i++) {
                        sb.append("0");
                    }
                    return sb.toString();
                }
            } else {
                StringBuilder sb = new StringBuilder(str);
                sb.append(".");
                for (int i = 0; i < decimal; i++) {
                    sb.append("0");
                }
                return sb.toString();
            }
        }
        return str;
    }


    public static String getTimeStamp() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(new Date());
    }


    /**
     * 16进制字符串转二进制字符串
     *
     * @param hexString 12进制字符串
     * @return 结果
     */
    public static String hexString2binaryString(String hexString) {
        if (hexString == null || hexString.length() % 2 != 0)
            return null;
        String bString = "", tmp;
        for (int i = 0; i < hexString.length(); i++) {
            tmp = "0000"
                    + Integer.toBinaryString(Integer.parseInt(hexString
                    .substring(i, i + 1), 16));
            bString += tmp.substring(tmp.length() - 4);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (bString.length() < 8) {
            for (int i = 0; i < 8 - bString.length(); i++) {
                stringBuffer.append("0");
            }
        }
        stringBuffer.append(bString);
        return stringBuffer.toString();
    }

}
