package com.chrispassold.kotlinsample.ui.base

import android.app.Activity
import android.content.Context
import com.chrispassold.kotlinsample.AppConstants

abstract class BaseFragment : androidx.fragment.app.Fragment(), AppConstants {

    protected lateinit var activity: Activity

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        this.activity = context as Activity
    }
}