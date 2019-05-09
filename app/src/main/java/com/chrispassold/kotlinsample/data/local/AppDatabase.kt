package com.chrispassold.kotlinsample.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.chrispassold.kotlinsample.data.local.converter.SampleListTypeConverter
import com.chrispassold.kotlinsample.data.local.dao.SampleDao
import com.chrispassold.kotlinsample.data.local.entity.SampleEntity

@Database(entities = [SampleEntity::class], version = 1, exportSchema = false)
@TypeConverters(
    SampleListTypeConverter::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun sampleDao(): SampleDao
}