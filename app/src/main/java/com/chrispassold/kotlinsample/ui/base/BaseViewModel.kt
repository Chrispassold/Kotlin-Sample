package com.chrispassold.kotlinsample.ui.base

import android.arch.lifecycle.ViewModel
import com.chrispassold.kotlinsample.AppConstants
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel(), AppConstants {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable();

    protected fun addToDisposable(disposable: Disposable) {
        compositeDisposable.remove(disposable)
        compositeDisposable.add(disposable)
    }

    fun onStop() {
        compositeDisposable.clear()
    }
}