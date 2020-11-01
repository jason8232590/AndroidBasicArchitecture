package com.example.myapplication.algorithm.sortMethod

class InsertSort {
    /**
     * 基本思想:就是将数组分成两个区间
     * 已排序区间
     * 和
     * 未排序区间
     * 从未排序区间取元素插入到已排序区间， 初始已排序区间默认只有一个元素，直到未排序区间元素为空，则排序结束
     * */


    /**
     * 这里从小到大排 5， 4,3,2,1
     *
     *1.时间复杂度   最好情况也要每个都比较一下，O(n),
     * 最坏的情况倒序每次都要在第一个位置插入数据（第一次移动1个数据，第n次移动n个数据）
     * 所以最坏时间复杂度是O(n2)
     *2.是原地排序   空间复杂度是O(1)
     *3.是稳定排序   后面出现的元素，可以插在前面出现元素的后面
     * */
    //a表示数组，n表示数组大小
    fun sort(array: Array<Int>, n:Int){
        if(n<=1) return
        for(i in 1 .. n-1){
            var value:Int = array[i]
            //已经排序区间元素只有一个
            var j = i-1

            for(j in j downTo 0 ){
                if(array[j] > value){
                    //如果未排序区间值更大  就把当前已排序值放后面
                    array[j+1] = array[j]
                }else{
                    break;
                }
            }
            array[j+1] = value
        }
     }

}