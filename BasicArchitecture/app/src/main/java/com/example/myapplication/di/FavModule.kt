package com.example.myapplication.di

import androidx.lifecycle.ViewModel
import com.example.myapplication.di.Utils.ViewModelBuilder
import com.example.myapplication.di.annotation.ViewModelKey
import com.example.myapplication.fragment.FavouriteFragment
import com.example.myapplication.fragment.HomeFragment
import com.example.myapplication.fragment.MoreFragment
import com.example.myapplication.viewmodel.FavouriteViewModel
import com.example.myapplication.viewmodel.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class FavModule {

    @ContributesAndroidInjector(modules = [
        ViewModelBuilder::class
    ])
    internal abstract fun favFragment(): FavouriteFragment

    @Binds
    @IntoMap
    @ViewModelKey(FavouriteViewModel::class)
    abstract fun bindViewModel(viewmodel: FavouriteViewModel): ViewModel
}
