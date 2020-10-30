package com.example.myapplication.algorithm.linklist

class solutionfor876 {
/**   给定一个头结点为 head 的非空单链表，返回链表的中间结点。
    如果有两个中间结点，则返回第二个中间结点。*/
    companion object{

        /**
         * 粗暴方法就是遍历整个链表然后中间节点就是n/2
         * 时间复杂度O(n)
         * 空间复杂度O(n) list得空间
         * */

        fun getMiddleNode(listNode: ListNode) : ListNode{
           var container:MutableList<ListNode> = mutableListOf()

            var t=0
            var head = listNode
            while (head != null){
                container.add(t++,head)
                head = head.next!!
            }
            return container.get(t/2)
        }

        /**
         *
         * 遍历两次，第一次得到链表长度
         * 第二次遍历到n/2就可以了
         * 时间复杂度O(n)
         * 空间复杂度O(1)
         * **/

//        fun getMiddleNode2(listNode: ListNode) : ListNode{
//            int n = 0;
//            ListNode cur = head;
//            while (cur != null) {
//                ++n;
//                cur = cur.next;
//            }
//            int k = 0;
//            cur = head;
//            while (k < n / 2) {
//                ++k;
//                cur = cur.next;
//            }
//            return cur;
//        }
    }
}