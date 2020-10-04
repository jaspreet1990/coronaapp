package com.corona.myapplication.domain

import com.corona.myapplication.repo.db.CoronaCoutryWiseTable
import com.corona.myapplication.repo.model.Province
import io.reactivex.Observable

class MockCoronaInfoUseCase: CoronaInfoService {

    override fun getAllCountries(): Observable<MutableList<CoronaCoutryWiseTable>> {

        var list =  mutableListOf(CoronaCoutryWiseTable("Abxc","2020-10-10",
            mutableListOf(Province(1,2,3,"av",4))))
        var coronaCoutryBasedListObs = Observable.just(list)
        return coronaCoutryBasedListObs
    }

    override fun getCasesBasedOnCountry(
        format: String,
        date: String,
        country: String
    ): Observable<CoronaCoutryWiseTable> {
        var data =  CoronaCoutryWiseTable("Abxc","2020-10-10",
            mutableListOf(Province(1,2,3,"av",4)))
        var coronaCoutryBasedListObs = Observable.just(data)
        return coronaCoutryBasedListObs
    }
}