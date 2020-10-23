package com.example.myapplication.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.myapplication.R
import com.example.myapplication.databinding.FavouriteFragmentBinding
import com.example.myapplication.databinding.MoreFragmentBinding
import com.example.myapplication.viewmodel.FavouriteViewModel
import com.example.myapplication.viewmodel.MoreViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MoreFragment : DaggerFragment() {

    private lateinit var viewDataBinding: MoreFragmentBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<MoreViewModel> { viewModelFactory }

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
    }
}