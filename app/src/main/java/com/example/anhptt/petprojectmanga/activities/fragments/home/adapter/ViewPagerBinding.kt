package com.example.anhptt.petprojectmanga.activities.fragments.home.adapter

import android.databinding.BindingAdapter
import com.example.anhptt.petprojectmanga.activities.fragments.home.model.Slideshow
import com.example.anhptt.petprojectmanga.utils.widget.ViewPagerCustomDuration


object ViewPagerBinding {

    @BindingAdapter("app:viewPagerList")
    @JvmStatic
    fun setSlideShowData(viewPager: ViewPagerCustomDuration, list: MutableList<Slideshow>?) {
        val adapter = viewPager.adapter as ViewPagerAdapter
        if (list != null) {
            adapter.replaceItem(list)
        } else {
            adapter.replaceItem(mutableListOf())
        }
    }

}