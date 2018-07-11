package com.example.anhptt.petprojectmanga.activities.fragments.home.view

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.anhptt.petprojectmanga.R
import com.example.anhptt.petprojectmanga.activities.fragments.home.adapter.ViewPagerAdapter
import com.example.anhptt.petprojectmanga.activities.fragments.home.viewmodel.HomeFragmentViewModel
import com.example.anhptt.petprojectmanga.activities.main.view.MainActivity
import com.example.anhptt.petprojectmanga.common.di.scope.PerFragment
import com.example.anhptt.petprojectmanga.common.fragment.BaseFragment
import com.example.anhptt.petprojectmanga.common.viewmodel.ViewModelFactory
import com.example.anhptt.petprojectmanga.databinding.FragmentHomeBinding
import javax.inject.Inject

@PerFragment
class HomeFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: HomeFragmentViewModel
    private lateinit var binding: FragmentHomeBinding
    private lateinit var mActivity: MainActivity
    private var adapter: ViewPagerAdapter? = null
    private var mHandler: Handler? = null
    private val delay: Long = 2000
    private var page: Int = 0
    private var runnable = object : Runnable {
        override fun run() {
            if (adapter?.count == page) {
                page = 0
            } else {
                page++
            }
            binding.viewPager.setCurrentItem(page, true)
            mHandler?.postDelayed(this, delay)
        }
    }


    companion object {
        val TAG = HomeFragment::class.java.name
        fun newInstance(): HomeFragment {
            val homeFragment = HomeFragment()
            return homeFragment
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mActivity = context as MainActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeFragmentViewModel::class.java)
        lifecycle.addObserver(viewModel)
        binding.viewModel = viewModel
        initViewPager()
        return binding.root
    }


    private fun initViewPager() {
        mHandler = Handler()
        adapter = ViewPagerAdapter(mActivity, viewModel, mutableListOf())
        binding.viewPager.setScrollDurationFactor(3.0)
        binding.viewPager.adapter = adapter
        binding.tabDots.setupWithViewPager(binding.viewPager)
    }

    override fun onStart() {
        super.onStart()
        mHandler?.postDelayed(runnable, delay)
    }

    override fun onDetach() {
        super.onDetach()
        mHandler?.removeCallbacks(runnable)
    }
}