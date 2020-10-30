package com.example.myapplication.algorithm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.algorithm.linklist.ListNode
import com.example.myapplication.algorithm.linklist.SolutionFor19
import com.example.myapplication.algorithm.linklist.getLength

class AlgorithmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_algorithm)
        testFor19()
    }

    fun testFor19() {
        var linkOne1: ListNode = ListNode(1)
        var linkOne2: ListNode = ListNode(2)
        var linkOne3: ListNode = ListNode(3)
        var linkOne4: ListNode = ListNode(4)
        var linkOne5: ListNode = ListNode(5)
        linkOne1.next = linkOne2
        linkOne2.next = linkOne3
        linkOne3.next = linkOne4
        linkOne4.next = linkOne5

        SolutionFor19.deleteAndReturn(linkOne1,3,::getLength)

    }


}