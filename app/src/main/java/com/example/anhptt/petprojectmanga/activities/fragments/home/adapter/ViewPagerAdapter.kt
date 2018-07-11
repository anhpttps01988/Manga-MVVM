package com.example.anhptt.petprojectmanga.activities.fragments.home.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.anhptt.petprojectmanga.R
import com.example.anhptt.petprojectmanga.activities.fragments.home.model.Slideshow
import com.example.anhptt.petprojectmanga.activities.fragments.home.viewmodel.HomeFragmentViewModel
import com.example.anhptt.petprojectmanga.databinding.ItemSlideshowBinding


class ViewPagerAdapter constructor(context: Context, viewModel: HomeFragmentViewModel, pagerList: MutableList<Slideshow>) : PagerAdapter() {

    private var context: Context = context
    private var viewModel: HomeFragmentViewModel = viewModel
    private var pageList: MutableList<Slideshow> = pagerList

    fun replaceItem(list: MutableList<Slideshow>) {
        if (list.size == 0) {
            val slideshow = Slideshow()
            slideshow.pictureUrl = "http://1.bp.blogspot.com/-PfNBlFO-Klw/Wujk5VH4YJI/AAAAAAACz0g/QHHeq2EPFZo2FylfPlghLfyIrYDcMrY0QCHMYCw/000.jpg?imgmax=16383"
            val slideShow2 = Slideshow()
            slideShow2.pictureUrl = "http://data.zidean.com/data/zv4_47/alextuan_36125_407545830302_102839635302_4977356_8350544_n_18446.jpg"
            list.add(slideshow)
            list.add(slideShow2)
        }
        setListItem(list)
    }

    private fun setListItem(list: MutableList<Slideshow>) {
        this.pageList = list
        notifyDataSetChanged()
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val data = pageList[position]
        val inflater = LayoutInflater.from(context)
        val binding = DataBindingUtil.inflate<ItemSlideshowBinding>(inflater, R.layout.item_slideshow, container, false)
        binding.data = data
        container.addView(binding.root)
        return binding.root
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return pageList.size
    }

}