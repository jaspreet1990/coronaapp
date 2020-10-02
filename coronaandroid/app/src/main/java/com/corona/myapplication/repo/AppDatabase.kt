package com.corona.myapplication.repo

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.corona.myapplication.repo.db.CoronaCoutryWiseTable

@Database(version = 1, entities = [CoronaCoutryWiseTable::class])
abstract class AppDatabase : RoomDatabase() {

    companion object {

        private val DB_NAME = "AppDatabase.db"


        fun createInstance(application: Application): AppDatabase {
            return Room.databaseBuilder(application, AppDatabase::class.java, DB_NAME)
                .build()
        }
    }
}