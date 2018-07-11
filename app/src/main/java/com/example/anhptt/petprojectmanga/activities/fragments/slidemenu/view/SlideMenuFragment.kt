package com.example.anhptt.petprojectmanga.activities.fragments.slidemenu.view

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.anhptt.petprojectmanga.R
import com.example.anhptt.petprojectmanga.common.di.scope.PerFragment
import com.example.anhptt.petprojectmanga.common.fragment.BaseFragment
import com.example.anhptt.petprojectmanga.common.viewmodel.ViewModelFactory
import com.example.anhptt.petprojectmanga.databinding.FragmentSlideMenuBinding
import com.example.anhptt.petprojectmanga.activities.main.view.MainActivity
import com.example.anhptt.petprojectmanga.activities.fragments.slidemenu.adapter.SlideMenuAdapter
import com.example.anhptt.petprojectmanga.activities.fragments.slidemenu.viewmodel.SlideMenuViewModel
import javax.inject.Inject

@PerFragment
open class SlideMenuFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: SlideMenuViewModel
    private lateinit var mBinding: FragmentSlideMenuBinding
    private lateinit var activity: MainActivity
    private var slideMenuCallback: SlideMenuCallback? = null

    fun getSlideMenuCallback(): SlideMenuCallback? {
        return slideMenuCallback
    }

    fun setSlideMenuCallback(slideMenuListener: SlideMenuCallback) {
        this.slideMenuCallback = slideMenuListener
    }

    companion object {
        fun newInstance(): SlideMenuFragment {
            val fragment = SlideMenuFragment()
            return fragment
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activity = context as MainActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_slide_menu, container, false)
        mBinding.setLifecycleOwner(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SlideMenuViewModel::class.java)
        lifecycle.addObserver(viewModel)
        mBinding.viewModel = viewModel
        initAdapterSlideMenu()
        return mBinding.root
    }

    private fun initAdapterSlideMenu() {
        val adapter = SlideMenuAdapter(viewModel, mutableListOf())
        mBinding.slideMenuList.layoutManager = LinearLayoutManager(activity, 1, false)
        mBinding.slideMenuList.adapter = adapter
        adapter.setSlideMenuCallback(object : SlideMenuAdapter.SlideMenuListener {
            override fun OnItemClick(position: Int) {
                getSlideMenuCallback()!!.onClick(position)
            }
        })
    }

    interface SlideMenuCallback {
        fun onClick(position: Int)
    }
}