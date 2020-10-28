package com.example.myapplication.di

import androidx.lifecycle.ViewModel
import com.example.myapplication.di.Utils.ViewModelBuilder
import com.example.myapplication.di.annotation.ViewModelKey
import com.example.myapplication.fragment.MoreFragment
import com.example.myapplication.viewmodel.MoreViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MoreModule {

    @ContributesAndroidInjector(modules = [
        ViewModelBuilder::class
    ])
    internal abstract fun moreFragment(): MoreFragment

    @Binds
    @IntoMap
    @ViewModelKey(MoreViewModel::class)
    abstract fun bindViewModel(viewmodel: MoreViewModel): ViewModel
}