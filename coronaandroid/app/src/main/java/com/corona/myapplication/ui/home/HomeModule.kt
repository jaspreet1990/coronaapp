package com.corona.myapplication.ui.home

import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides

@Module
class HomeModule {
    @Provides
    fun provideViewModel(homeActivity: HomeActivity, homeViewModelFactory: HomeViewModelFactory ) = ViewModelProvider(homeActivity, homeViewModelFactory).get(
        HomeViewModel::class.java)

}
