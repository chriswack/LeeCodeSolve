package com.wack.code.util;


public class Tool {

    public interface Exec {
        void onExec();
    }

    /**
     * 耗时
     *
     * @param exec 执行
     */
    public static void costTime(Exec exec) {
        costTime(1, exec);
    }

    /**
     * 耗时
     *
     * @param times 次数
     * @param exec  执行
     */
    public static void costTime(int times, Exec exec) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            if (exec != null) exec.onExec();
        }
        System.out.println((System.currentTimeMillis() - start) + "ms");
    }

    /**
     * 获得测试数据
     *
     * @param length 长度
     * @return 结果
     */
    public static int[] getTest(int length) {
        int[] n = new int[length];
        for (int i = 0; i < length; i++) {
            n[i] = i;
        }
        return n;
    }
}
