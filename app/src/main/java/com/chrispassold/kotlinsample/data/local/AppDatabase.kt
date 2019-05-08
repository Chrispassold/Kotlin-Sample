package com.chrispassold.kotlinsample.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.chrispassold.kotlinsample.data.local.entity.SampleEntity

@Database(entities = [SampleEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase()