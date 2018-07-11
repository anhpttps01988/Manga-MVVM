package com.example.anhptt.petprojectmanga.common.di

import com.example.anhptt.petprojectmanga.common.di.scope.PerActivity
import com.example.anhptt.petprojectmanga.activities.main.di.MainActivityModule
import com.example.anhptt.petprojectmanga.activities.main.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class BaseActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [BaseActivityModule::class, MainActivityModule::class])
    abstract fun mainActivity(): MainActivity

}