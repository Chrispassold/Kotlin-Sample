package com.chrispassold.kotlinsample.ui.main.activity

import android.support.v4.app.Fragment
import com.chrispassold.kotlinsample.ui.base.BaseActivity
import dagger.android.AndroidInjector
import dagger.android.support.HasSupportFragmentInjector

class MainActivity : BaseActivity(), HasSupportFragmentInjector {
    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}