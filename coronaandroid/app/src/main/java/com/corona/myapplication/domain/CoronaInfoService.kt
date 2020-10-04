package com.corona.myapplication.domain

import com.corona.myapplication.repo.db.CoronaCoutryWiseTable
import io.reactivex.Observable

interface CoronaInfoService {

    fun getAllCountries(): Observable<MutableList<CoronaCoutryWiseTable>>

    fun getCasesBasedOnCountry(format: String, date: String, country: String): Observable<CoronaCoutryWiseTable>
}