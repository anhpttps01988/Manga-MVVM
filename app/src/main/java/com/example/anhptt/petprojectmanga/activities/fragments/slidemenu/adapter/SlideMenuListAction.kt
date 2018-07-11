package com.example.anhptt.petprojectmanga.activities.fragments.slidemenu.adapter

import android.view.View
import com.example.anhptt.petprojectmanga.activities.fragments.slidemenu.model.SlideMenu


interface SlideMenuListAction {
    fun onClick(slideMenu: SlideMenu, view: View)
}