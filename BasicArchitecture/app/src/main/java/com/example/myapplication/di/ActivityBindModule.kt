package com.example.myapplication.di

import com.example.myapplication.MainActivity
import com.example.myapplication.activity.AboutMoreActivity
import com.example.myapplication.activity.LoginActivity
import com.example.myapplication.slidemenuactivity.CustomViewActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindModule {
    @ContributesAndroidInjector
    abstract fun MainActivityInjector() : MainActivity

    @ContributesAndroidInjector
    abstract fun LoginActivity() : LoginActivity

    @ContributesAndroidInjector
    abstract fun AboutMoreActivity() : AboutMoreActivity

    @ContributesAndroidInjector
    abstract fun CustomViewActivity() : CustomViewActivity
}