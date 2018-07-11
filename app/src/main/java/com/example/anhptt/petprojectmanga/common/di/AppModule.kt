package com.example.anhptt.petprojectmanga.common.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [BaseViewModelModule::class])
abstract class AppModule {

    @Singleton
    @Binds
    abstract fun context(application: Application): Context

}