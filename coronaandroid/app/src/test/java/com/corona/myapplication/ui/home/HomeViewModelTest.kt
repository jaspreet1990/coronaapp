package com.corona.myapplication.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.corona.myapplication.domain.CoronaInfoService
import com.corona.myapplication.domain.MockCoronaInfoUseCase
import com.corona.myapplication.repo.db.CoronaCoutryWiseTable
import com.corona.myapplication.repo.model.Province
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.MockitoAnnotations

class HomeViewModelTest {

    @get:Rule
     val instantExecutorRule = InstantTaskExecutorRule()

    lateinit var coronaInfoSevrice: CoronaInfoService

    lateinit var homeViewModel: HomeViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        coronaInfoSevrice = MockCoronaInfoUseCase()
        homeViewModel = HomeViewModel(coronaInfoSevrice)
    }

    @Test
    fun testGetAllCountries() {
        val list =  mutableListOf(coronaData())

        homeViewModel.getAllCountries()
        homeViewModel.countryBasedCoronaResponseLiveData.postValue(list)
        homeViewModel.countryBasedCoronaResponseLiveData
            .observeForever {
            assertEquals(list[0], it[0])
        }
 }
    @Test
    fun testGetCasesBasedOnCountry() {

        homeViewModel.getCasesBasedOnCountry("in")
        homeViewModel.countryCoronaData.postValue(coronaData())
        homeViewModel.countryCoronaData.observeForever {
            assertEquals(coronaData(),it)
        }
    }

    fun coronaData() = CoronaCoutryWiseTable("Abxc","2020-10-10",
        mutableListOf(Province(1,2,3,"av",4)))
}
