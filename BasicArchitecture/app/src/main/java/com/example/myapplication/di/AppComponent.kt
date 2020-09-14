package com.example.myapplication.di

import android.app.Application
import com.example.myapplication.base.DxApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

//不用dagger.Android的问题
//1.每一个需要注入依赖的页面Activity或Fragment都需要创建一个Component类
//2.继承关系中第二步，每个subComponent都需要在parent component声明对应的subComponent.Builder的忌口
//3.在Activity或Fragment中注入依赖时，都必须知道其对应的注入器(Component)的类型， 这样做有悖于依赖注入的原则：被注入的类不应该知道依赖注入的任何细节

//Install AndroidInjectionModule in your application component to ensure that all bindings necessary for these base types are available.
@Singleton
@Component(modules = [NetworkModule::class, AndroidInjectionModule::class, ActivityBindModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(application: DxApplication)
}