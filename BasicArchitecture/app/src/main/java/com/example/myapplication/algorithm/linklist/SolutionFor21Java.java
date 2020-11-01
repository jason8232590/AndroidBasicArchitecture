package com.example.myapplication.algorithm.linklist;


public class SolutionFor21Java {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.getValue() <= l2.getValue()) {
                prev.setNext(l1);
                l1 = l1.getNext();
            } else {
                prev.setNext(l2);
                l2 = l2.getNext();
            }
            //相当于是把prehead的next变成了 prev,
            //?????
            prev = prev.getNext();
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        if(l1 == null){
            prev.setNext(l2);
        }else{
            prev.setNext(l1);
        }

        return prehead.getNext();
    }
}
