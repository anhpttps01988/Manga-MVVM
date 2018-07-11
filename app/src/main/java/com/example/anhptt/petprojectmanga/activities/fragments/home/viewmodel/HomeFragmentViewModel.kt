package com.example.anhptt.petprojectmanga.activities.fragments.home.viewmodel

import android.annotation.SuppressLint
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.os.AsyncTask
import com.example.anhptt.petprojectmanga.activities.fragments.home.model.Slideshow
import com.example.anhptt.petprojectmanga.common.viewmodel.BaseViewModel
import com.example.anhptt.petprojectmanga.service.Constants
import javax.inject.Inject


class HomeFragmentViewModel @Inject constructor() : BaseViewModel(), LifecycleObserver, HomeFragmentContract.ViewHolderContract {

    var viewPagerList = MutableLiveData<MutableList<Slideshow>>()
    var isLoading = MutableLiveData<Boolean>()


    override fun create() {
        super.create()
        initSlideshow()
    }

    override fun initSlideshow() {
        LoadSlideShow().execute(Constants.URL_SLIDE_SHOW)
    }


    @SuppressLint("StaticFieldLeak")
    inner class LoadSlideShow : AsyncTask<String, Void, MutableList<Slideshow>>() {

        override fun onPreExecute() {
            isLoading.value = false
            super.onPreExecute()
        }

        override fun doInBackground(vararg params: String?): MutableList<Slideshow> {
            val list: MutableList<Slideshow> = mutableListOf()
            return list
        }

        override fun onPostExecute(result: MutableList<Slideshow>?) {
            super.onPostExecute(result)
        }
    }

}