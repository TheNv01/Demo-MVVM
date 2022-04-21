package com.example.demomvvm.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.demomvvm.model.Country

@Dao
interface CountryDAO {
    @Insert(onConflict = REPLACE)
    suspend fun insertAllData(countries: List<Country>)

    @Query("select * from country")
    fun getAllData(): List<Country>
}