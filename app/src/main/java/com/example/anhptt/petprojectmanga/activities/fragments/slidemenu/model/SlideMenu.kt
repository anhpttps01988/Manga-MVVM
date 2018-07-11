package com.example.anhptt.petprojectmanga.activities.fragments.slidemenu.model

import com.example.anhptt.petprojectmanga.R


class SlideMenu constructor() {


    var name: String? = null
    var isSelection = false
    var isHeader = false
    var counter = 0
    var icon = 0

    fun getSlideMenuList(): MutableList<SlideMenu> {
        val slideMenuList: MutableList<SlideMenu> = mutableListOf()
        val slideHeaderMenu = SlideMenu()
        slideHeaderMenu.name = "CỦA TÔI"
        slideHeaderMenu.icon = 0
        slideHeaderMenu.isSelection = false
        slideHeaderMenu.isHeader = true
        slideHeaderMenu.counter = 0
        val slideMenuItem1 = SlideMenu()
        slideMenuItem1.name = "Trang Chủ"
        slideMenuItem1.icon = R.drawable.ic_home
        slideMenuItem1.isSelection = true
        slideMenuItem1.isHeader = false
        slideMenuItem1.counter = 0
        val slideMenuItem2 = SlideMenu()
        slideMenuItem2.name = "Thể Loại"
        slideMenuItem2.icon = R.drawable.ic_category
        slideMenuItem2.isSelection = false
        slideMenuItem2.isHeader = false
        slideMenuItem2.counter = 0
        val slideMenuItem3 = SlideMenu()
        slideMenuItem3.name = "Yêu Thích"
        slideMenuItem3.icon = R.drawable.ic_favorite
        slideMenuItem3.isSelection = false
        slideMenuItem3.isHeader = false
        slideMenuItem3.counter = 0
        val slideMenuItem4 = SlideMenu()
        slideMenuItem4.name = "Tải Xuống"
        slideMenuItem4.icon = R.drawable.ic_download
        slideMenuItem4.isSelection = false
        slideMenuItem4.isHeader = false
        slideMenuItem4.counter = 0
        slideMenuList.add(slideHeaderMenu)
        slideMenuList.add(slideMenuItem1)
        slideMenuList.add(slideMenuItem2)
        slideMenuList.add(slideMenuItem3)
        slideMenuList.add(slideMenuItem4)
        val slideHeaderMenu2 = SlideMenu()
        slideHeaderMenu2.name = "TIỆN ÍCH"
        slideHeaderMenu2.icon = 0
        slideHeaderMenu2.isSelection = false
        slideHeaderMenu2.isHeader = true
        slideHeaderMenu2.counter = 0
        val slideMenuItem5 = SlideMenu()
        slideMenuItem5.name = "Chia Sẽ"
        slideMenuItem5.icon = R.drawable.ic_share
        slideMenuItem5.isSelection = false
        slideMenuItem5.isHeader = false
        slideMenuItem5.counter = 0
        val slideMenuItem6 = SlideMenu()
        slideMenuItem6.name = "Cài Đặt"
        slideMenuItem6.icon = R.drawable.ic_settings
        slideMenuItem6.isSelection = false
        slideMenuItem6.isHeader = false
        slideMenuItem6.counter = 0
        val slideMenuItem7 = SlideMenu()
        slideMenuItem7.name = "Thoát"
        slideMenuItem7.icon = R.drawable.ic_exit
        slideMenuItem7.isSelection = false
        slideMenuItem7.isHeader = false
        slideMenuItem7.counter = 0
        slideMenuList.add(slideHeaderMenu2)
        slideMenuList.add(slideMenuItem5)
        slideMenuList.add(slideMenuItem6)
        slideMenuList.add(slideMenuItem7)
        return slideMenuList
    }

}