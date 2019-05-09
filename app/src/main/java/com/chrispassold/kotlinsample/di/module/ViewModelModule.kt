package com.chrispassold.kotlinsample.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chrispassold.kotlinsample.factory.ViewModelFactory
import com.chrispassold.kotlinsample.ui.main.viewmodel.SampleViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SampleViewModel::class)
    protected abstract fun sampleViewModel(moviesListViewModel: SampleViewModel): ViewModel
}