package com.chrispassold.kotlinsample.di.module

import android.app.Application
import androidx.annotation.NonNull
import androidx.room.Room
import com.chrispassold.kotlinsample.data.local.AppDatabase
import com.chrispassold.kotlinsample.data.local.dao.SampleDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DbModule {

    /*
     * The method returns the Database object
     * */
    @Provides
    @Singleton
    fun provideDatabase(@NonNull application: Application): AppDatabase = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "DatabaseName.db"
    ).allowMainThreadQueries().build()

    @Provides
    @Singleton
    internal fun provideSampleDao(appDatabase: AppDatabase): SampleDao = appDatabase.sampleDao()
}