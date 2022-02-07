package leetcode.editor.cn;

import java.math.BigDecimal;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        random();

    }

    private static void random() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(""+BigDecimal.valueOf(random.nextDouble()).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        }
    }


    private static void testCheck() {
        String reg = "\\D+(\\d+)$";    //提取字符串末尾的数字
        String s = "湖南省长沙市天心区金地三千府七期G2299-1";
        Pattern p2 = Pattern.compile(reg);
        Matcher m2 = p2.matcher(s);
        if (m2.find()) {
            System.out.println(m2.group(1));  // 组提取字符串
        } else {
            System.out.println("123");  // 组提取字符串
        }
    }
}
