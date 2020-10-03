package com.corona.myapplication.repo

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.corona.myapplication.repo.db.Converters
import com.corona.myapplication.repo.db.CoronaCoutryWiseTable
import com.corona.myapplication.repo.db.CoronaDao
import java.io.Serializable

@Database(version = 1, entities = [CoronaCoutryWiseTable::class])
//@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase(){

    abstract fun coronaDao() : CoronaDao
    companion object {
        private val DB_NAME = "AppDatabase.db"


        fun createInstance(application: Application): AppDatabase {
            return Room.databaseBuilder(application, AppDatabase::class.java, DB_NAME)
                .build()
        }
    }
}