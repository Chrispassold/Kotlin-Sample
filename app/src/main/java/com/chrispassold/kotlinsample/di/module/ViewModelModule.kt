package com.chrispassold.kotlinsample.di.module

import android.arch.lifecycle.ViewModelProvider
import com.chrispassold.kotlinsample.factory.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}