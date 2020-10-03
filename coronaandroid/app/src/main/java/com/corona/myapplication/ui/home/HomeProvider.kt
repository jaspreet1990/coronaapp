package com.corona.myapplication.ui.home

import com.corona.myapplication.ui.detail.DetailFrg
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeProvider {

    @ContributesAndroidInjector(modules = [(HomeModule::class)])
    abstract fun bindHomeFrg(): HomeFrg

    @ContributesAndroidInjector(modules = [(HomeModule::class)])
    abstract fun bindDetailFrg(): DetailFrg



}