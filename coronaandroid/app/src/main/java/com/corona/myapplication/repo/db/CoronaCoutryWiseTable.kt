package com.corona.myapplication.repo.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Corona_Country_Wise")
data class CoronaCoutryWiseTable(

    @PrimaryKey val id: Int,
    @ColumnInfo(name = "country_name") val countryName: String?
)