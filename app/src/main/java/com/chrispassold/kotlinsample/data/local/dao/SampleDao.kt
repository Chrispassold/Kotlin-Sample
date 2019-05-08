package com.chrispassold.kotlinsample.data.local.dao

import android.arch.persistence.room.*
import com.chrispassold.kotlinsample.data.local.entity.SampleEntity
import io.reactivex.Flowable

@Dao
interface SampleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<SampleEntity>): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: SampleEntity): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateMovie(movie: SampleEntity): Int

    @Query("SELECT * FROM `SampleEntity` where id = :id")
    fun getMovieById(id: Long?): SampleEntity

    @Query("SELECT * FROM `SampleEntity` where id = :id")
    fun getMovieDetailById(id: Long?): Flowable<SampleEntity>
}