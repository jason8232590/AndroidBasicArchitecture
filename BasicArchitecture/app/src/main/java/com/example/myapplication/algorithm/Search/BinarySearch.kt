package com.example.myapplication.algorithm.Search



class BinarySearch {
//    <1>基本思想
//    二分查找针对的是一个有序的数据集合，查找思想类似分治思想，每次都通过跟区间的中间元素对比，将待查找的区间缩小一半，直到找到要查找的元素，或者区间被缩小为0
//
//    <2>使用场景
//    1)必须是顺序结构，因为二分查找通过下标随机访问元素
//    2)数据太少不适合，直接遍历就好，数据太大也不适合，因为二分查找依赖数组这种数据结构，它的空间是连续的，如果要查找1GB的数据，那就意味要1GB的连续空间
//
//    <3>时间复杂度
//    时间复杂度是O(logn)
//    1.每次都只是两个元素比对
//    第一次是 查找区间 n个元素
//    第二次是 查找区间 n/2 个元素
//    第K次是 查找区间 n/2^k-1 个元素
//    第K次区间变成1个元素
//    K = logn
//    所以时间复杂度是O(n)

/**
 * 变种问题(这时候数组里面有重复的元素)
 * 1.查找第一个等于 value 的， 只需要判断index-1是不是也等于value就行了
 * 2.查找最后一个等于vlaue的， 只需要判断index+1 是不是也等于value就行了
 * 3.查找第一个大于等于value的，
 * 如果a[mid] 大于等于给定vlaue
 * (1)a[mid]是不是第一个元素，如果不是就判断a[mid-1]是不是也大于等于value
 * (2)如果不是那a[mid]就是我们要找的
 * (3)如果是那就说明我们要找的数在 low .. mid-1 这个范围里
 *
 * 4.查找最后一个大于等于value的
 * 原理同上
 * */
    fun seach(array: Array<Int>, n:Int, value:Int) :Int{

        var low: Int = 0
        var high : Int = n -1

        while (low<=high){

            var mid = (low + high)/2
            if(array[mid] == value){
                return mid
            }else if (array[mid] <value){
                low = mid +1
            }else{
                high = mid -1
            }

        }
        return -1
    }

    /***
     * 用递归实现
     * 其实每次都是更新low 跟 high
     * */

    fun seachRecusion(array: Array<Int>, n:Int, value:Int) : Int{
        return seachRecursionInternally(array,0,n-1,value)
    }

    fun seachRecursionInternally(array: Array<Int>, low:Int, high:Int, value:Int) :Int{

        if (low > high) return -1
        val mid = low + (high - low)/2
         if (array[mid] === value) {
             return mid
        } else if (array[mid] < value) {
            return seachRecursionInternally(array, mid + 1, high, value)
        } else {
            return seachRecursionInternally(array, low, mid - 1, value)
        }
    }
}