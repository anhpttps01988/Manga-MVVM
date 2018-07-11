package com.example.anhptt.petprojectmanga.activities.fragments.slidemenu.viewmodel

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import com.example.anhptt.petprojectmanga.R
import com.example.anhptt.petprojectmanga.common.viewmodel.BaseViewModel
import com.example.anhptt.petprojectmanga.activities.fragments.slidemenu.model.SlideMenu
import javax.inject.Inject

class SlideMenuViewModel @Inject constructor() : BaseViewModel(), LifecycleObserver, SlideMenuFragmentContract.ViewModelContract {
    var slideMenuListLiveData = MutableLiveData<MutableList<SlideMenu>>()

    override fun create() {
        super.create()
        initSlideMenu()
    }

    override fun initSlideMenu() {
        this.slideMenuListLiveData.postValue(SlideMenu().getSlideMenuList())
    }

    override fun selectedSlideMenu(slideMenu: SlideMenu, position: Int) {
        this.slideMenuListLiveData.value!![position] = slideMenu
    }
}