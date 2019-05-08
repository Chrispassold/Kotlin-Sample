package com.chrispassold.kotlinsample.data.remote.model

import com.chrispassold.kotlinsample.data.local.entity.SampleEntity

data class SampleApiResponse (val page: Long,
                         val results: List<SampleEntity>,
                         val total_results: Long,
                         val total_pages: Long)