package com.example.anhptt.petprojectmanga.common.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.anhptt.petprojectmanga.activities.fragments.home.viewmodel.HomeFragmentViewModel
import com.example.anhptt.petprojectmanga.common.di.scope.ViewModelKey
import com.example.anhptt.petprojectmanga.common.viewmodel.ViewModelFactory
import com.example.anhptt.petprojectmanga.activities.main.viewmodel.MainActivityViewModel
import com.example.anhptt.petprojectmanga.activities.fragments.slidemenu.viewmodel.SlideMenuViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class BaseViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun mainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SlideMenuViewModel::class)
    abstract fun slideMenuViewModel(slideMenuViewModel: SlideMenuViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeFragmentViewModel::class)
    abstract fun homeViewModel(homeViewModel: HomeFragmentViewModel): ViewModel

    @Binds
    abstract fun viewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}