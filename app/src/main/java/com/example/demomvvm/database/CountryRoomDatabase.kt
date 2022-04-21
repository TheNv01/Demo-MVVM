package com.example.demomvvm.database

import android.content.Context
import androidx.room.*
import com.example.demomvvm.TypeConverter
import com.example.demomvvm.model.Country

@Database(entities = [Country::class], version = 1, exportSchema = false)
@TypeConverters(TypeConverter::class)
abstract class CountryRoomDatabase: RoomDatabase() {
    abstract fun countryDAO(): CountryDAO

    object CountryDatabaseBuilder{

        private var instance: CountryRoomDatabase? = null

        fun getInstance(context: Context): CountryRoomDatabase{
            if (instance == null){
                synchronized(CountryRoomDatabase::class){
                    if(instance == null){
                        instance = Room.databaseBuilder(context.applicationContext,
                            CountryRoomDatabase::class.java, "countries database")
                            .allowMainThreadQueries()
                            .build()
                    }
                }

            }
            return instance!!
        }
    }
}