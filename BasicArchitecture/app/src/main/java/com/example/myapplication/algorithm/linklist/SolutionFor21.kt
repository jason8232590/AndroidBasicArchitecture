package com.example.myapplication.algorithm.linklist

class SolutionFor21 {
    /**
     * 只要遇到递归，我们就把它抽象成一个递推公式，不用想一层层的调用关系，不要试图用人脑去分解递归的每个步骤。
     * 1.一个问题可以分解成几个子问题的解
     * 2.这个问题与分解之后的子问题，除了数据规模不一样，求解思路一样
     * 3.存在递归终止条件
     *
     * 警惕
     * 1.递归很深，堆栈溢出的问题       限制递归深度
     * 2.如果存在脏数据，可能无线递归    限制递归深度
     *
     *将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 示例：

    输入：1->2->4, 1->3->4
    输出：1->1->2->3->4->4
     * */

    /**
     * 假如链表one 有 n个 结点  链表two有m 个结点
     * 在下面的过程中每个节点只会被遍历，所以时间复杂度就是O(N+M)
     * 堆栈深度n+m
     *
     * */
    //mergeTwoListOrderlink 返回较小值的结点，并设置下一个节点
    fun mergeTwoListOrderlinkRecursion(linkOne : ListNode?, linkTwo: ListNode?) : ListNode?{
        if(linkOne == null && linkTwo == null)  return null

        if(linkOne == null) return linkTwo
        if(linkTwo == null) return linkOne

        if(linkOne.value < linkTwo.value) {
            linkOne.next = mergeTwoListOrderlinkRecursion(linkOne.next, linkTwo)
            return linkOne
        }else{
            linkTwo.next = mergeTwoListOrderlinkRecursion(linkOne,linkTwo.next)
            return linkTwo
        }
    }

    /**
     * 空间复杂度为O(1),只需要常数的空间存放若干变量
     * 时间复杂度为
     *
     * */
    fun mergeTwoListOrderList(linkOne: ListNode?, linkTwo: ListNode?) : ListNode?{
//        if(linkOne == null && linkTwo == null)  return null
//
//        if(linkOne == null) return linkTwo
//        if(linkTwo == null) return linkOne

        //如果我们引入哨兵结点，在任何时候，不管链表是不是空，head 指针都会一直指向这个哨兵结点。我们也把这种有哨兵结点的链表叫带头链表。
        // 相反，没有哨兵结点的链表就叫作不带头链表。
        //假如哨兵指针是方便逻辑实现(这样就不用判断头指针是否为null)
        var preHead : ListNode = ListNode(-1)
        var prev: ListNode = preHead

        while (linkOne != null && linkTwo != null){
            if(linkOne.value <= linkTwo.value){
                //将小值插入到头指针后面
                prev.next = linkOne

                //linkone is not allowed here
                //linkone  = linkOne.next
                //在原有链表中去掉小值
                prev.next!!.next = linkOne.next

            }else{

                prev.next = linkTwo
                //linkTwo is not allowed here
                //linkTwo = linkTwo.next
                prev.next!!.next = linkTwo.next
            }

            //第一次执行就替换掉哨兵结点
            prev = prev.next!!
        }
        // 合并后 l1 和 l2 最多只有一个元素还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        if (linkOne == null){
            prev.next = linkTwo
        }else{
            prev.next = linkOne
        }
        return preHead.next

    }
}