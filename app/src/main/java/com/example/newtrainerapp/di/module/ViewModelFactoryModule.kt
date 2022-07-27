package com.example.newtrainerapp.di.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import com.example.newtrainerapp.viewmodels.DaggerViewModelFactory

/**
 * Created by Microstar on 02.06.2020.
 */
@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactor(modelProviderFactory: DaggerViewModelFactory?): ViewModelProvider.Factory?
}