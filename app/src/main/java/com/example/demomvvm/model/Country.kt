package com.example.demomvvm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "country")
@Serializable
data class Country(
    @PrimaryKey @ColumnInfo(name = "name")
    val name: Name,
    @ColumnInfo(name = "capital")
    val capital: List<String>?)
