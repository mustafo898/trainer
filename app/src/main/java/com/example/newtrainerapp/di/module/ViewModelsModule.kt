package com.example.newtrainerapp.di.module

import androidx.lifecycle.ViewModel
import com.example.newtrainerapp.di.scopes.ViewModelKey
import com.example.newtrainerapp.mvvm.ActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ActivityViewModel::class)
    abstract fun mainViewModel(activityViewModel: ActivityViewModel): ViewModel

}