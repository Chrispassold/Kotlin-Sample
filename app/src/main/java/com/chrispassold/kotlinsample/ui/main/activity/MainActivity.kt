package com.chrispassold.kotlinsample.ui.main.activity

import android.os.Bundle
import android.os.PersistableBundle
import com.chrispassold.kotlinsample.ui.base.BaseActivity
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : BaseActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<androidx.fragment.app.Fragment>

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        AndroidInjection.inject(this)
    }

    override fun supportFragmentInjector(): DispatchingAndroidInjector<androidx.fragment.app.Fragment> {
        return dispatchingAndroidInjector
    }
}