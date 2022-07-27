package com.example.newtrainerapp.di.module

import com.example.newtrainerapp.MainActivity
import com.example.newtrainerapp.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Microstar on 02.06.2020.
 */

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [ViewModelsModule::class, MainFragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector()
    abstract fun contributeSplashActivity(): SplashActivity

//    @ContributesAndroidInjector(modules = [MainFragmentBuildersModule::class, ViewModelsModule::class])
//    abstract fun contributeHumoPayActivity(): HumoPayActivity
//
//    @ContributesAndroidInjector(modules = [LoginFragmentsBuildersModule::class, ViewModelsModule::class])
//    abstract fun contributeLoginActivity(): LoginActivity


}