package com.chrispassold.kotlinsample.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.support.annotation.NonNull
import com.chrispassold.kotlinsample.database.AppDatabase
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
    fun provideDatabase(@NonNull application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java, "DatabaseName.db"
        ).allowMainThreadQueries().build()
    }
}