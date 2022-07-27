package com.example.newtrainerapp.di.module

import com.example.newtrainerapp.ui.LoginFragment
import com.example.newtrainerapp.ui.SignUpFragment
import com.example.newtrainerapp.ui.TrainerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Microstar on 02.06.2020.
 */
@Module
abstract class MainFragmentBuildersModule {

//    @ContributesAndroidInjector
//    abstract fun splashFragment(): SplashFragment

    @ContributesAndroidInjector
    abstract fun signupFragment(): SignUpFragment

    @ContributesAndroidInjector
    abstract fun loginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun trainerFragment(): TrainerFragment


}