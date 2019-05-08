package com.chrispassold.kotlinsample.ui.main.viewmodel

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import com.chrispassold.kotlinsample.data.Resource
import com.chrispassold.kotlinsample.data.local.dao.SampleDao
import com.chrispassold.kotlinsample.data.local.entity.SampleEntity
import com.chrispassold.kotlinsample.data.remote.api.SampleApiService
import com.chrispassold.kotlinsample.data.repository.SampleRepository
import com.chrispassold.kotlinsample.ui.base.BaseViewModel
import javax.inject.Inject

class SampleViewModel @Inject constructor(
    sampleDao: SampleDao,
    sampleApiService: SampleApiService
) : BaseViewModel() {

    private lateinit var type: String
    private val sampleRepository: SampleRepository = SampleRepository(sampleDao, sampleApiService)
    private val sampleLiveData = MutableLiveData<Resource<List<SampleEntity>>>()


    fun setType(type: String) {
        this.type = type
    }

    @SuppressLint("CheckResult")
    fun loadMoreSample(currentPage: Long) {
        sampleRepository.loadSample(currentPage, type)
            .doOnSubscribe { disposable -> addToDisposable(disposable) }
            .subscribe { resource -> getSampleLiveData().postValue(resource) }
    }

    private fun getSampleLiveData() = sampleLiveData
}