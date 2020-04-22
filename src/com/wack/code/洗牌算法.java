package com.wack.code;


import java.util.Arrays;
import java.util.Random;

public class 洗牌算法 {


    public static void main(String[] args) {
        //生成数组
        Integer[] arrs = new Integer[10];
        for (int i = 0; i < arrs.length; i++) {
            arrs[i] = i;
        }
        System.out.println(Arrays.toString(arrs));
        for (int i = 0; i < 10; i++) {
            random(arrs);//洗牌
            System.out.println(Arrays.toString(arrs));
        }

    }


    /**
     * 洗牌算法
     *
     * @param arrs 数组
     */
    public static void random(Object[] arrs) {
        Random random = new Random();
        for (int i = arrs.length - 1; i >= 0; i--) {
            swap(arrs, i, random.nextInt(i + 1));
        }
    }

    /**
     * 交换位置
     *
     * @param arrs 数组
     * @param pos1 位置1
     * @param pos2 位置2
     */
    private static void swap(Object[] arrs, int pos1, int pos2) {
        Object temp = arrs[pos1];
        arrs[pos1] = arrs[pos2];
        arrs[pos2] = temp;
    }
}
