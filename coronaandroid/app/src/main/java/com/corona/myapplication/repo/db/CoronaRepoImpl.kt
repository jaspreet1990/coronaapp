package com.corona.myapplication.repo.db

import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class CoronaRepoImpl @Inject constructor(private val coronaDao: CoronaDao) : CoronaRepo {

    override fun insertCoronaInfo(info: CoronaCoutryWiseTable) {
        Completable.fromAction{ coronaDao.insertCoronaInfo(info)}
    }

    override fun insertCoronaInfoList(info: List<CoronaCoutryWiseTable>) {
        Completable.fromAction{ coronaDao.insertCoronaInfoList(info)}

    }

    override fun getAllCountries(): Observable<MutableList<CoronaCoutryWiseTable>> {
       return coronaDao.getAllCountries()
    }

    override fun updateCountryCoronaData(info: CoronaCoutryWiseTable) {
        Completable.fromAction { coronaDao.updateCountryCoronaData(info) }
    }

    override fun getCountryData(country: String): Observable<CoronaCoutryWiseTable> {
       return coronaDao.getCountryData(country)
    }
}