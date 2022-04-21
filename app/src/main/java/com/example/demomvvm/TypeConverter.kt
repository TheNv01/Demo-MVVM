package com.example.demomvvm

import androidx.room.TypeConverter
import com.example.demomvvm.model.Name
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
class TypeConverter {

    @TypeConverter
    fun fromName(name: Name): String?{
        return Gson().toJson(name)
    }

    @TypeConverter
    fun toName(common: String): Name?{
        return Gson().fromJson(common, Name::class.java)
    }
    @TypeConverter
    fun fromListString(list: List<String>?): String?{
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().toJson(list, listType)

    }

    @TypeConverter
    fun toListString(capital: String): List<String>? {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson<List<String>>(capital, listType)

    }

}