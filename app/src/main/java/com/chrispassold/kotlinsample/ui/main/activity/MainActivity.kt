package com.chrispassold.kotlinsample.ui.main.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import com.chrispassold.kotlinsample.ui.base.BaseActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.support.HasSupportFragmentInjector

class MainActivity : BaseActivity(), HasSupportFragmentInjector {

    //private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        AndroidInjection.inject(this)
      //  binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}