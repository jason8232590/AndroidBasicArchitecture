package com.example.myapplication.algorithm.sortMethod

class QuickSort {
    /** 假设数组A[p ---- r]
     * 基本思想：分治思想，从 p 到 r 之间挑一个元素 pivot , 比这个大的放左边，比这个小的放右边
     * 这样数据就分成三部分   > pivot   pivot   <pivot
     *
     * 递归公式：（q是pivot）
     * quick_sort(p...r) = quick_sort(p...q-1) + quick_sort(q+1....r)
     * 终止条件：
     * p >= r   （数组只剩下一个元素）
     * **/


    /**
     * 伪代码
     *
    // 快速排序，A是数组，n表示数组的大小
        quick_sort(A, n) {
        quick_sort_c(A, 0, n-1)
        }

        // 快速排序递归函数，p,r为下标
        quick_sort_c(A, p, r) {
        if p >= r then return

        q = partition(A, p, r) // 获取分区点
        quick_sort_c(A, p, q-1)
        quick_sort_c(A, q+1, r)
        }
     *
     *
     * //分区函数
     * 1.通过游标i 把 A[p...r-1]分成两部分 已处理区 A[p ... i-1] 和 未处理区 A[ i ... r-1]
     * 2.每次都是未处理区A[i .. r-1] 中取出一个元素 A[j] 与 pivot对比 ，
     * 3。如果小于 则插入已处理区 A[p ... i -1]的尾部 也就是 A[i]
        partition(A, p, r) {
        pivot := A[r]
        i := p
        for j := p to r-1 do {
        if A[j] < pivot {
        swap A[i] with A[j]
        i := i+1
        }
        }
        swap A[i] with A[r]
        return i

     *
     * **/

    /***
     * 1.时间复杂度  递归分析
     * T(1) = C  只要常量级别的执行时间
     * T(n) = 2*T(n/2) + n
     * 剩下的就跟归并排序的一样的
     * 所以时间复杂度是 O(nlogn)
     *
     * 但是上面的前提是数组恰巧能一分为二，实际上很难，会出现下面这样的情况
     * T(1) = C； n=1时，只需要常量级的执行时间，所以表示为C。
     * T(n) = T(n/10) + T(9*n/10) + n； n>1
     * 要用递归树的方法来推导了
     * 先给出结论;
     * 大部分时候： 时间复杂度是 O(nlogn)
     * 极端情况下： 退化到O(n^2)
     *
     * 2.是原地排序
     *
     * 3.不是稳定排序
     *
     *
     * */
}