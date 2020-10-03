package com.corona.myapplication.repo.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface CoronaDao {

    @Insert
    fun insertCoronaInfo(info: CoronaCoutryWiseTable)

    @Insert
    fun insertCoronaInfoList(info: List<CoronaCoutryWiseTable>)

    @Query("SELECT * from Corona_Country_Wise")
    fun getAllCountries() : Observable<MutableList<CoronaCoutryWiseTable>>

    @Update
    fun updateCountryCoronaData(info: CoronaCoutryWiseTable)

    @Query("SELECT * from Corona_Country_Wise where country_name = :country")
    fun getCountryData(country: String) : Observable<CoronaCoutryWiseTable>

}