package com.example.anhptt.petprojectmanga.activities.fragments.slidemenu.adapter

import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.transition.Slide
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.anhptt.petprojectmanga.R
import com.example.anhptt.petprojectmanga.databinding.ItemSlideMenuBinding
import com.example.anhptt.petprojectmanga.activities.fragments.slidemenu.model.SlideMenu
import com.example.anhptt.petprojectmanga.activities.fragments.slidemenu.view.SlideMenuFragment
import com.example.anhptt.petprojectmanga.activities.fragments.slidemenu.viewmodel.SlideMenuViewModel


class SlideMenuAdapter(viewModel: SlideMenuViewModel, slideMenu: MutableList<SlideMenu>) : RecyclerView.Adapter<SlideMenuAdapter.ViewHolder>() {

    private var slideMenulist: MutableList<SlideMenu>? = null
    private var viewModel: SlideMenuViewModel? = null
    private var rowIndex = -1

    private var slideMenuCallback : SlideMenuListener? = null

    fun getSlideMenuCallback(): SlideMenuListener? {
        return slideMenuCallback
    }

    fun setSlideMenuCallback(slideMenuListener: SlideMenuListener) {
        this.slideMenuCallback = slideMenuListener
    }

    init {
        setSlideMenuList(slideMenu)
        this.viewModel = viewModel
    }

    fun replaceData(slideMenuList: MutableList<SlideMenu>) {
        setSlideMenuList(slideMenuList)
    }

    private fun setSlideMenuList(slideMenuList: MutableList<SlideMenu>) {
        this.slideMenulist = slideMenuList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_slide_menu, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return slideMenulist!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val slideMenu = slideMenulist!![position]
        val listener = object : SlideMenuListAction {
            override fun onClick(slideMenu: SlideMenu, view: View) {
                getSlideMenuCallback()!!.OnItemClick(position)
                rowIndex = position
                notifyDataSetChanged()
            }
        }
        if (rowIndex == -1 && position == 1) {
            slideMenu.isSelection = true
        } else {
            slideMenu.isSelection = rowIndex == position
        }
        viewModel!!.selectedSlideMenu(slideMenu, position)
        holder.binding.listener = listener
        holder.bind(slideMenu)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: ItemSlideMenuBinding = DataBindingUtil.bind(itemView)!!
        fun bind(slideMenu: SlideMenu) {
            binding.slideMenu = slideMenu
            binding.executePendingBindings()
        }
    }

    interface SlideMenuListener {
        fun OnItemClick(position: Int)
    }
}