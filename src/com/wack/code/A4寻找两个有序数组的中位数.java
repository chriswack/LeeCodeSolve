package com.wack.code;

import java.util.Arrays;

public class A4寻找两个有序数组的中位数 {
    public static void main(String[] args) {
        double midd = new A4寻找两个有序数组的中位数().findMedianSortedArrays(new int[]{5, 7, 2, 1, 1}, new int[]{1, 2, 8, 4, 9});
        System.out.println(midd);
    }


    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0) {
            if (n % 2 != 0) return 1.0 * nums2[n / 2];
            return (nums2[n / 2] + nums2[n / 2 - 1]) / 2.0;
        }
        if (n == 0) {
            if (m % 2 != 0) return 1.0 * nums1[m / 2];
            return (nums1[m / 2] + nums1[m / 2 - 1]) / 2.0;
        }
        int total = m + n;
        //总数为奇数，找第 total / 2 + 1 个数
        if ((total & 1) == 1) {
            return find_kth(nums1, 0, nums2, 0, total / 2 + 1);
        }
        //总数为偶数，找第 total / 2 个数和第total / 2 + 1个数的平均值
        return (find_kth(nums1, 0, nums2, 0, total / 2) + find_kth(nums1, 0, nums2, 0, total / 2 + 1)) / 2.0;
    }

    public int find_kth(int[] a, int a_begin, int[] b, int b_begin, int k) {
        //当a 或 b 超过数组长度，则第k个数为另外一个数组第k个数
        if (a_begin >= a.length) return b[b_begin + k - 1];
        if (b_begin >= b.length) return a[a_begin + k - 1];
        //k为1时，两数组最小的那个为第一个数
        if (k == 1)  return Math.min(a[a_begin], b[b_begin]);
        int mid_a = Integer.MAX_VALUE;
        int mid_b = Integer.MAX_VALUE;
        //mid_a / mid_b 分别表示 a数组、b数组中第 k / 2 个数
        if (a_begin + k / 2 - 1 < a.length)
            mid_a = a[a_begin + k / 2 - 1];
        if (b_begin + k / 2 - 1 < b.length)
            mid_b = b[b_begin + k / 2 - 1];
        //如果a数组的第 k / 2 个数小于b数组的第 k / 2 个数，表示总的第 k 个数位于 a的第k / 2个数的后半段，或者是b的第 k / 2个数的前半段
        //由于范围缩小了 k / 2 个数，此时总的第 k 个数实际上等于新的范围内的第 k - k / 2个数，依次递归
        if (mid_a < mid_b)
            return find_kth(a, a_begin + k / 2, b, b_begin, k - k / 2);
        //否则相反
        return find_kth(a, a_begin, b, b_begin + k / 2, k - k / 2);
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = Arrays.copyOf(nums1, nums1.length + nums2.length);//数组扩容
        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
        quickSort(nums, 0, nums.length - 1);
        int pos = nums.length / 2;
        if (nums.length % 2 == 1) {
            return nums[pos];
        } else {
            return (nums[pos - 1] + nums[pos]) / 2.0;
        }
    }

    private void quickSort(int[] array, int low, int high) {
        if (low > high) return;
        int mid = getMiddle(array, low, high);
        quickSort(array, low, mid - 1);
        quickSort(array, mid + 1, high);
    }

    private int getMiddle(int[] list, int low, int high) {
        int tmp = list[low];//数组的第一个作为中轴
        while (low < high) {
            while (low < high && list[high] >= tmp) high--;
            list[low] = list[high];//比中轴小的记录移到低端
            while (low < high && list[low] <= tmp) low++;
            list[high] = list[low];//比中轴大的记录移到高端
        }
        list[low] = tmp;//中轴记录到尾
        return low;//返回中轴的位置
    }
}
