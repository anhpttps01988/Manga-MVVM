package com.example.anhptt.petprojectmanga.activities.fragments.slidemenu.viewmodel

import com.example.anhptt.petprojectmanga.activities.fragments.slidemenu.model.SlideMenu

interface SlideMenuFragmentContract {

    interface ViewModelContract {
        fun initSlideMenu()
        fun selectedSlideMenu(slideMenu: SlideMenu, position: Int)
    }

    interface Navigator {

    }

}