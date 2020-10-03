package com.corona.myapplication.repo.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.corona.myapplication.repo.model.Province

@Entity(tableName = "Corona_Country_Wise")
@TypeConverters(DataConverter::class)
data class CoronaCoutryWiseTable(

    @PrimaryKey
    @ColumnInfo(name = "country_name") val countryName: String,
    @ColumnInfo(name = "date") val date: String?,
    @ColumnInfo(name = "province") val province : List<Province>
)