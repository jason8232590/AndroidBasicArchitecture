package com.example.myapplication.algorithm.linklist


class SolutionFor141 {

    /***
     * 给定一个链表，判断链表中是否有环。

    如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
    我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
    如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

     *
     * */

    companion object{
        /**
         * 很明显时间复杂度是O(n)因为要遍历n
         * 因为要存储n个节点，所以空间复杂度O(n)
         * */
        fun hasCycle( listNode: ListNode?) : Boolean{
            var accessRecord:MutableSet<ListNode> = mutableSetOf()
            var head = listNode
            while (head != null){
                if(!accessRecord.add(head)){
                    return true;
                }
                head = head.next
            }
            return false;
        }

        /**
         *
         * 快慢指针 ， 加入跑道是直得，那么兔子肯定在乌龟前面，但是如果跑道是环形得就会出现，乌龟兔子相遇得情况
         * 时间复杂度是O（n）
         * 空间复杂度是O(1)
         * */

        fun hasCycleQuickAndSlow(listNode: ListNode?) : Boolean{
            if (listNode?.next == null) {
                return false;
            }
            var slow:ListNode = listNode
            var quick:ListNode = listNode.next!!

            while (slow!=quick){
                if (quick == null || slow.next == null) {
                    return false
                }
                slow = slow.next!!
                quick = quick.next?.next!!
            }

            return true
        }
    }




}