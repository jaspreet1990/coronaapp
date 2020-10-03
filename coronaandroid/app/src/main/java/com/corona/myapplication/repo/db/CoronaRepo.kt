package com.corona.myapplication.repo.db

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Observable
import io.reactivex.Single

interface CoronaRepo {

    @Insert(
        onConflict = OnConflictStrategy.REPLACE
    )
    fun insertCoronaInfo(info: CoronaCoutryWiseTable)


    @Insert(
        onConflict = OnConflictStrategy.REPLACE
    )
    fun insertCoronaInfoList(info: List<CoronaCoutryWiseTable>)

    @Query("SELECT * from Corona_Country_Wise")
    fun getAllCountries() : Observable<MutableList<CoronaCoutryWiseTable>>

    @Update
    fun updateCountryCoronaData(info: CoronaCoutryWiseTable)

    @Query("SELECT * from Corona_Country_Wise where country_name = :country")
    fun getCountryData(country: String) : Observable<CoronaCoutryWiseTable>


}