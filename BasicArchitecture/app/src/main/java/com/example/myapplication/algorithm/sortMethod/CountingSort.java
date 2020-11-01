package com.example.myapplication.algorithm.sortMethod;

//计数排序
public class CountingSort {

    /**
     * 特殊的桶排序，区别在于桶的颗粒度的大小
     * 桶排序的桶可能存 0 -99
     *
     * 但是计数排序的桶里面的值只能是一个  (用于统计不同分数的人数)
     * 叫计数排序的原因是因为他的实现方式是计数的
     *只能从尾部去遍历原数组，否则就不是稳定排序
     * */

    /**
     * 1.时间复杂度  O（n）
     * 2.是稳定排序  从尾部遍历原数组
     * 3.不是原地排序  因为要创建数组
     * */

    // 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数。
    public void countingSort(int[] a, int n) {
        if (n <= 1) return;

        // 查找数组中数据的范围
        int max = a[0];
        for (int i = 1; i < n; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        int[] c = new int[max + 1]; // 申请一个计数数组c，下标大小[0,max]
        for (int i = 0; i <= max; ++i) {
            c[i] = 0;
        }

        // 计算每个元素的个数，放入c中
        for (int i = 0; i < n; ++i) {
            c[a[i]]++;
        }

        // 依次累加
        for (int i = 1; i <= max; ++i) {
            c[i] = c[i-1] + c[i];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[n];
        // 计算排序的关键步骤，有点难理解
        for (int i = n - 1; i >= 0; --i) {
            int index = c[a[i]]-1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 将结果拷贝给a数组
        for (int i = 0; i < n; ++i) {
            a[i] = r[i];
        }
    }
}
