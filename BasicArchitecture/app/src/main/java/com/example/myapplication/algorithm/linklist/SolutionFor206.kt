package com.example.myapplication.algorithm.linklist

class SolutionFor206 {
    /**
     *
    反转一个单链表。

    示例:

    输入: 1->2->3->4->5->NULL
    输出: 5->4->3->2->1->NULL
     * */
    companion object{
        /**
         *时间复杂度 O（n）
         * 空间复杂度O(1)
         * 没看懂？？？？
         * */
        fun reverseList(listNode: ListNode?) : ListNode?{
            var prev:ListNode? = null
            var curr:ListNode? = listNode

            while (curr != null){
                //取出下一个节点
                var nextTemp : ListNode? = curr.next
                //prev尾插
                curr.next = prev

                //当前节点变成prev  准备尾插
                prev = curr

                //下一个节点放到 当前
                curr = nextTemp
            }
            return prev

        }

    }
}