package com.chrispassold.kotlinsample.data.local.converter

import androidx.room.TypeConverter
import com.chrispassold.kotlinsample.data.local.entity.SampleEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class SampleListTypeConverter {

    @Inject
    lateinit var gson: Gson

    @TypeConverter
    fun fromString(value: String): List<SampleEntity>? {
        val listType = object : TypeToken<List<SampleEntity>>() {}.type
        return gson.fromJson<List<SampleEntity>>(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<SampleEntity>?): String {
        return gson.toJson(list)
    }
}