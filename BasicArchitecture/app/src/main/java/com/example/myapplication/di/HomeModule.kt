package com.example.myapplication.di

import androidx.lifecycle.ViewModel
import com.example.myapplication.di.Utils.ViewModelBuilder
import com.example.myapplication.di.annotation.ViewModelKey
import com.example.myapplication.fragment.HomeFragment
import com.example.myapplication.viewmodel.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class HomeModule {

    @ContributesAndroidInjector(modules = [
        ViewModelBuilder::class
    ])
    internal abstract fun homeFragment(): HomeFragment

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindViewModel(viewmodel: HomeViewModel): ViewModel
}
