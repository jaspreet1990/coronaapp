package com.corona.myapplication.domain

import com.corona.myapplication.repo.ApiService
import com.corona.myapplication.repo.db.CoronaCoutryWiseTable
import com.corona.myapplication.repo.db.CoronaDao
import com.corona.myapplication.repo.model.CoronaInfoBasedOnCountry
import com.corona.myapplication.repo.model.CoronaInfoBasedOnCountryItem
import com.corona.myapplication.repo.model.CountryResponse
import com.corona.myapplication.repo.model.CountryResponseItem
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class CoronaInfoUseCaseTest {

    lateinit var coronaInfoUseCase: CoronaInfoUseCase

    @Mock
    lateinit var apiService: ApiService

    @Mock
    lateinit var coronaDao: CoronaDao

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        coronaInfoUseCase = CoronaInfoUseCase(apiService,coronaDao)
    }

    @Test
    fun testGetCountries() {
        var countryRes = CountryResponse()
        countryRes.add(CountryResponseItem("a","A",0.0, 0.0,"ds"))
        val obs = Observable.just(countryRes)

        whenever(apiService.getCountries()).thenReturn(obs)
        var testObs =  coronaInfoUseCase.getAllCountries().test()
        testObs.assertValue(mutableListOf(CoronaCoutryWiseTable("ds","", mutableListOf())))

    }

   @Test
    fun testGetCoronaBasedOnCounries(){

       var coronaInfoBasedOnCountry = CoronaInfoBasedOnCountry()
       coronaInfoBasedOnCountry.add(CoronaInfoBasedOnCountryItem("in","20-10-12", 0.0, 0.0, mutableListOf()))

       val obs = Observable.just(coronaInfoBasedOnCountry)

       whenever(apiService.getCoronaNumberBasedOnCountry("YYYY-DD-MM","20-10-12", "in"))
           .thenReturn(obs)
      var testObs =  coronaInfoUseCase.getCasesBasedOnCountry("YYYY-DD-MM","20-10-12", "in").test()

       testObs.assertValues(CoronaCoutryWiseTable("in","20-10-12", mutableListOf()))
   }
}