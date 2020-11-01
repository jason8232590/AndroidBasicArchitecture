package com.example.myapplication.algorithm.stack

import java.util.*

class soluationFor155 {

    /**    设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

    push(x) —— 将元素 x 推入栈中。
    pop() —— 删除栈顶的元素。
    top() —— 获取栈顶元素。
    getMin() —— 检索栈中的最小元素。

     */
    /**
     * 1.维持两个栈，一个栈存元素，一个栈存最小值
     * 存最小值的栈，可以保证栈顶一定是最小的元素
     *
     * 时间复杂度是O（1）
     * 空间复杂度  最坏的情况是 O(n)
     * */
    companion object {
        var xStack:LinkedList<Int> = LinkedList()
        var minStack:LinkedList<Int> = LinkedList()

        fun push(x:Int){
            xStack.push(x)
            minStack.push(Math.min(minStack.peek(),x))
        }

        fun pop(){
            xStack.pop()
            minStack.pop()
        }

        fun top(): Int{
            return xStack.peek()
        }

        fun getMin(): Int{
            return minStack.peek()
        }

    }


}