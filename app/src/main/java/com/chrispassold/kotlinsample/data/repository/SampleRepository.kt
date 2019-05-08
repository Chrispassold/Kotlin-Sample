package com.chrispassold.kotlinsample.data.repository

import com.chrispassold.kotlinsample.data.NetworkBoundResource
import com.chrispassold.kotlinsample.data.Resource
import com.chrispassold.kotlinsample.data.local.dao.SampleDao
import com.chrispassold.kotlinsample.data.local.entity.SampleEntity
import com.chrispassold.kotlinsample.data.remote.api.SampleApiService
import com.chrispassold.kotlinsample.data.remote.model.SampleApiResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Singleton

@Singleton
class SampleRepository(
    private val sampleDao: SampleDao,
    private val sampleApiService: SampleApiService
) {

    fun loadSample(page: Long, type: String): Observable<Resource<List<SampleEntity>>> {
        return object : NetworkBoundResource<List<SampleEntity>, SampleApiResponse>() {

            override fun saveCallResult(item: SampleApiResponse) {
                //save the result from endpoint
            }

            override fun shouldFetch(): Boolean {
                return true
            }

            override fun loadFromDb(): Flowable<List<SampleEntity>> {
                //Load from local
                return Flowable.empty()
            }

            override fun createCall(): Observable<Resource<SampleApiResponse>> {
                return sampleApiService.fetchSample(type, page)
                    .flatMap { movieApiResponse ->
                        Observable.just(
                            Resource.success(movieApiResponse)
                            //OR
                            // Resource.error("", SampleApiResponse(page, emptyList(), 0, 1))
                        )
                    }
            }
        }.getAsObservable()
    }
}