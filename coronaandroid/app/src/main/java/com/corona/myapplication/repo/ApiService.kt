package com.corona.myapplication.repo

import com.corona.myapplication.repo.model.CoronaInfoBasedOnCountry
import com.corona.myapplication.repo.model.CountryResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryName

interface ApiService {

    @GET("/help/countries")
    fun getCountries(): Observable<CountryResponse>

    @GET("report/country/name")
    fun getCoronaNumberBasedOnCountry(
        @Query("date-format") dateFormat: String,
        @Query("date") date: String,
        @Query("name") name: String
        ): Observable<CoronaInfoBasedOnCountry>
}