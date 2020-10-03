package com.corona.myapplication.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.corona.myapplication.domain.CoronaInfoUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeViewModelFactory  @Inject constructor(
    private val coronaInfoUseCase: CoronaInfoUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {

            return HomeViewModel(coronaInfoUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}