package com.chrispassold.kotlinsample.data.remote.api

import com.chrispassold.kotlinsample.data.remote.model.SampleApiResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SampleApiService {

    @GET("movie/{type}?language=en-US&region=US")
    fun fetchSample(
        @Path("type") type: String,
        @Query("page") page: Long
    ): Observable<SampleApiResponse>
}