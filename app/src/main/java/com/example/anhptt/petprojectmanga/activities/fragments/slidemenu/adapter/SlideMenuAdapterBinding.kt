package com.example.anhptt.petprojectmanga.activities.fragments.slidemenu.adapter

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.example.anhptt.petprojectmanga.activities.fragments.slidemenu.model.SlideMenu


object SlideMenuAdapterBinding {

    @BindingAdapter("app:slideMenuList")
    @JvmStatic
    fun getSlideMenuList(recyclerView: RecyclerView, slideMenuList: MutableList<SlideMenu>?) {
        val adapter = recyclerView.adapter as SlideMenuAdapter
        if (slideMenuList != null) {
            adapter.replaceData(slideMenuList)
        } else {
            adapter.replaceData(mutableListOf())
        }
    }
}