package com.corona.myapplication.domain

import android.util.Log
import com.corona.myapplication.repo.ApiService
import com.corona.myapplication.repo.db.CoronaCoutryWiseTable
import com.corona.myapplication.repo.db.CoronaDao
import com.corona.myapplication.repo.model.Province
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class CoronaInfoUseCase @Inject constructor(
    private val apiService: ApiService,
    private val coronaDao: CoronaDao
) {

    fun getAllCountries(): Observable<MutableList<CoronaCoutryWiseTable>> {
        val observableFromApi = getAllCountriesFromApi()
        val observableFromDb = getAllCountriesFromDB()
        return Observable.concatArrayDelayError(observableFromApi, observableFromDb).distinct()
    }

    fun getAllCountriesFromApi(): Observable<MutableList<CoronaCoutryWiseTable>> {
        return apiService.getCountries()

            .map {
                Log.e(" API Size ", it.size.toString())
                var list = mutableListOf<CoronaCoutryWiseTable>()
                for (item in it) {
                    list.add(CoronaCoutryWiseTable(item.name, "", emptyList<Province>()))
                }
                return@map list
            }.doOnNext {
                coronaDao.insertCoronaInfoList(it)
            }
            .flatMap {
                return@flatMap Observable.just(it)
            }
    }

    fun getAllCountriesFromDB(): Observable<MutableList<CoronaCoutryWiseTable>> {
        return coronaDao.getAllCountries()
    }

    fun getCasesBasedOnCountry(format: String, date: String, country: String): Observable<CoronaCoutryWiseTable> {
        val fromApi = getCasesBasedOnCountryFromApi(format, date, country)
        val fromDB = getCasesBasedOnCountryFromDB(country)
        return Observable.concatArrayDelayError(fromApi, fromDB).distinct()

    }

    fun getCasesBasedOnCountryFromApi(format: String, date: String, country: String):
            Observable<CoronaCoutryWiseTable> {

         return apiService
            .getCoronaNumberBasedOnCountry(format, date, country)
            .map {
                var list = mutableListOf<CoronaCoutryWiseTable>()
                for (item in it) {
                    list.add(CoronaCoutryWiseTable(item.country, item.date, item.provinces))
                }
                 list[0]
            }.doOnNext {
                coronaDao.updateCountryCoronaData(it)

            }.flatMap {
                  Observable.just(it)
            }
    }

    fun getCasesBasedOnCountryFromDB(countryName: String): Observable<CoronaCoutryWiseTable> {
       return coronaDao.getCountryData(countryName)
    }


}