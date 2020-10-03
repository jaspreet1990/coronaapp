package com.corona.myapplication.di.module

import android.app.Application
import com.corona.myapplication.repo.AppDatabase
import com.corona.myapplication.repo.db.CoronaRepo
import com.corona.myapplication.repo.db.CoronaRepoImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {

    @Provides
    @Singleton
    internal fun provideAppDb(application: Application) = AppDatabase.createInstance(application)

    @Provides
    @Singleton
    internal fun provideUserDao(appDb: AppDatabase) = appDb.coronaDao()

    @Singleton
    @Provides
    internal fun userRepo(coronaRepoImpl: CoronaRepoImpl): CoronaRepo = coronaRepoImpl
}