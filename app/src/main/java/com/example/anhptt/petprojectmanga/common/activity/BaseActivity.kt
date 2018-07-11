package com.example.anhptt.petprojectmanga.common.activity

import android.app.Activity
import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.*
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


open class BaseActivity : AppCompatActivity(), HasActivityInjector, HasFragmentInjector, HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingActivityAndroidInjector: DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var dispatchingFragmentAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var dispatchingSupportFragmentAndroidInjector: DispatchingAndroidInjector<android.support.v4.app.Fragment>

    override fun supportFragmentInjector(): AndroidInjector<android.support.v4.app.Fragment> {
        return dispatchingSupportFragmentAndroidInjector
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityAndroidInjector
    }

    override fun fragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingFragmentAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }
}