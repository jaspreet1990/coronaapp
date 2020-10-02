package com.corona.myapplication.di.module

import android.app.Application
import com.corona.myapplication.repo.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {

    @Provides
    @Singleton
    internal fun provideAppDb(application: Application) = AppDatabase.createInstance(application)
}