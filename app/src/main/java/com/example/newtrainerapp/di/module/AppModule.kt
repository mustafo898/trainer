package com.example.newtrainerapp.di.module

import android.app.Application
import com.example.newtrainerapp.utils.SharedPref
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Microstar on 02.06.2020.
 */

@Module(
    includes = [
        NetworkModule::class,
    ]
)
object AppModule {

    @Singleton
    @Provides
    fun provideShared(application: Application) = SharedPref(application.applicationContext)

//    @Singleton
//    @Provides
//    fun provideGson() = Gson()
}