package com.example.myapplication.algorithm.sortMethod

class BublbleSort {

    /**
     * 冒泡排序
     * 基于比较
     * 比较相邻的两个元素，大的或者小的往后排，直到没有数据交换操作
     * 这里我们排个从小到大的数组
     * */

    /**
     * 如何分析算法的
     * 1.排序算法的执行效率    时间复杂度，最好，最坏复杂度等等
     * 2.排序算法的内存消耗    是否是原地排序(空间复杂度为O（1）)
     * 3.排序算法的稳定        值相等的元素的位置是否变换
     * */


    /**
     * 冒泡排序分析
     * 1.最好是O(n),最坏就是需要进行n次冒泡(第一次交换 n-1， 第二次 n-2,第n次1),所以最坏时间复杂度是O(n2)
     * 2.是原地排序，只消耗了一个临时变量,时间复杂度是O(1)
     * 3.是稳定排序    相等的值前后顺序没有变
     *
     * */
    //array表达数组，n表示数组大小
    fun sort(array: Array<Int>, n: Int){
        for (i in 0..n-1){
            //排序完成标志
            var breakFlag: Boolean = false

            //注意计算是从0开始还是n开始
            //第一次的交换次数是 n-1
            //第x词的交换次数n-x
            for ( j in 0..n-i-2){
                if(array[j] > array[j+1]){
                    //交换顺序
                    var tmp: Int = array[j]
                    array[j] = array[j+1]
                    array[j+1] = tmp
                    breakFlag = true
                }
            }
            //没有数据交换就完成了排序
            if(!breakFlag) break
        }

    }

}