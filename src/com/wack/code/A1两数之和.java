package com.wack.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class A1两数之和 {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{1, 2, 4, 5}, 6);

        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tar = target - nums[i];
            if (map.containsKey(tar)) {
                return new int[]{i, map.get(tar)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
