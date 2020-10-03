package com.corona.myapplication.di.builder

import com.corona.myapplication.ui.home.HomeActivity
import com.corona.myapplication.ui.home.HomeProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(HomeProvider::class)])
    abstract fun bindHome() : HomeActivity
}