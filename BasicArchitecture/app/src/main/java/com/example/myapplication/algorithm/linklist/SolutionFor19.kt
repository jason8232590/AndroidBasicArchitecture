package com.example.myapplication.algorithm.linklist

inline  fun  getLength(listNode: ListNode?): Int {
    var localistNode = listNode
    var length = 0;

    while (localistNode != null) {
        ++length;
        localistNode = localistNode.next
    }

    return length
}

class SolutionFor19 {
    /**
     * 给定一个链表，删除链表的 倒数第 n 个节点 ，并且返回链表的头结点。
     *给定一个链表: 1->2->3->4->5, 和 n = 2.
     *当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * */

    companion object{


        /**
         * //遍历到要删除的节点前面，然后把这个节点跳过直接连接  下个节点 ，就把这个节点删了
         *
         * 空间复杂度是常数o（1）
         * 时间复杂度也就是 最坏是O（n）
         * 平均复杂度是也是O（n）
         *
         * */
         fun deleteAndReturn(
            listNode: ListNode?,
            deleteIndex: Int,
            getLength: (ListNode) -> Int
        ): ListNode? {

            var dummyNode : ListNode = ListNode(0, listNode)
            var length = getLength(listNode)
            var currentNode = dummyNode

            //1,2,3,4,5  刪除倒数第2個(从1开始数)   length-deleteIndex+1 =4

            for (i in 1 .. length-deleteIndex){
                //节点length-
                currentNode = currentNode.next!!
            }
            currentNode.next = currentNode.next!!.next

            var ans: ListNode? = dummyNode.next
            return ans
        }

    }
}

