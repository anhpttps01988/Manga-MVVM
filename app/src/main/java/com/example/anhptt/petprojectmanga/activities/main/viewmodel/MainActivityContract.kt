package com.example.anhptt.petprojectmanga.activities.main.viewmodel


interface MainActivityContract {

    interface ViewModelContract{

    }

    interface Navigator{
        fun goToHome()
        fun goToCategory()
        fun goToFavorite()
        fun goToDownload()
        fun goToShare()
        fun goToSettings()
        fun goToExit()
    }

}