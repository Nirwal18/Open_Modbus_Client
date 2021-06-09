package com.nirwal.openmodbusclient.di

import android.app.Application
import com.nirwal.openmodbusclient.MyApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideBaseApplication(context: Application):MyApp{
        return context as MyApp
    }

//
//    @Singleton
//    @Provides
//    fun stringHelp():String{
//        return "Hello text string from module"
//    }

}