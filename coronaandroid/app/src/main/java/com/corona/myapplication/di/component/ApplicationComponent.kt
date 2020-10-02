package com.corona.myapplication.di.component

import com.corona.myapplication.MyApplication
import com.corona.myapplication.di.builder.ActivityBuilder
import com.corona.myapplication.di.module.ApplicationModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (ApplicationModule::class), (ActivityBuilder::class) ])
interface ApplicationComponent {

    fun inject(app: MyApplication)

}