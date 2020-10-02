package com.corona.myapplication.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [(DbModule::class)])
class ApplicationModule (val app: Application){

    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    @Singleton
    fun provideContext(): Context =app

}