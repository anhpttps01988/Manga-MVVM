package com.example.anhptt.petprojectmanga.activities.main.di

import com.example.anhptt.petprojectmanga.activities.fragments.home.di.HomeFragmentModule
import com.example.anhptt.petprojectmanga.activities.fragments.home.view.HomeFragment
import com.example.anhptt.petprojectmanga.common.di.BaseActivityModule
import com.example.anhptt.petprojectmanga.common.di.BaseFragmentModule
import com.example.anhptt.petprojectmanga.common.di.scope.PerFragment
import com.example.anhptt.petprojectmanga.activities.fragments.slidemenu.di.SlideMenuFragmentModule
import com.example.anhptt.petprojectmanga.activities.fragments.slidemenu.view.SlideMenuFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @PerFragment
    @ContributesAndroidInjector(modules = [BaseActivityModule::class, SlideMenuFragmentModule::class, BaseFragmentModule::class])
    abstract fun slideMenuFragment(): SlideMenuFragment

    @PerFragment
    @ContributesAndroidInjector(modules = [BaseActivityModule::class, HomeFragmentModule::class, BaseFragmentModule::class])
    abstract fun homeFragment(): HomeFragment
}