package com.example.myapplication.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.Service.MyConnection
import com.example.myapplication.Service.TestService
import com.example.myapplication.algorithm.AlgorithmActivity
import com.example.myapplication.databinding.MoreFragmentBinding
import com.example.myapplication.viewmodel.MoreViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MoreFragment : DaggerFragment(), View.OnClickListener {

    private lateinit var viewDataBinding: MoreFragmentBinding
    private lateinit var serviceIntent: Intent
    private lateinit var myConnection: MyConnection

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<MoreViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(
            inflater, R.layout.more_fragment, container,
            false
        )

        println("xcqw $viewModel")
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.viewModel = viewModel
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner

        viewDataBinding.btBindService.setOnClickListener(this)
        viewDataBinding.btStartBindService.setOnClickListener(this)
        viewDataBinding.btStartService.setOnClickListener(this)
        viewDataBinding.btStopService.setOnClickListener(this)
        viewDataBinding.btUnbindService.setOnClickListener(this)
        viewDataBinding.btStopunbindService.setOnClickListener(this)
        viewDataBinding.btStartActivty.setOnClickListener(this)
        serviceIntent = Intent(activity, TestService::class.java)
        myConnection = MyConnection()


    }



    fun testFor21() {
        var linkOne1: ListNode = ListNode(1)
        var linkOne2: ListNode = ListNode(2)
        var linkOne3: ListNode = ListNode(4)
        linkOne1.next = linkOne2
        linkOne2.next = linkOne3

        var linkTwo1: ListNode = ListNode(1)
        var linkTwo2: ListNode = ListNode(3)
        var linkTwo3: ListNode = ListNode(5)
        linkTwo1.next = linkTwo2
        linkTwo2.next = linkTwo3


        var finalListNode: ListNode = SolutionFor21Java.mergeTwoLists(linkOne1, linkTwo1)
        println("xcqw " + finalListNode.toString())
    }

    override fun onClick(v: View?) {
        when (v) {
            viewDataBinding.btBindService -> {
                activity?.bindService(serviceIntent, myConnection, Context.BIND_AUTO_CREATE)
            }
            viewDataBinding.btStartBindService -> {
                println("xcqw btStopunbindService")
            }
            viewDataBinding.btStartService -> {
                activity?.startService(serviceIntent)

            }
            viewDataBinding.btStopService -> {
                activity?.stopService(serviceIntent)
            }
            viewDataBinding.btUnbindService -> {
                activity?.unbindService(myConnection)
            }
            viewDataBinding.btStopunbindService -> println("xcqw btStopunbindService")

            viewDataBinding.btStartActivty -> activity?.startActivity(Intent(activity,AlgorithmActivity::class.java))
        }
    }

    fun callService() {
        myConnection.myBinder.callBackMethodService(200)
    }

    fun callServiceDirect() {
        val tService = TestService()
        tService.methodService()
    }


}