package com.example.anhptt.petprojectmanga.activities.main.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import com.example.anhptt.petprojectmanga.R
import com.example.anhptt.petprojectmanga.activities.fragments.home.view.HomeFragment
import com.example.anhptt.petprojectmanga.common.activity.BaseActivity
import com.example.anhptt.petprojectmanga.common.di.scope.PerActivity
import com.example.anhptt.petprojectmanga.common.viewmodel.ViewModelFactory
import com.example.anhptt.petprojectmanga.databinding.ActivityMainBinding
import com.example.anhptt.petprojectmanga.activities.main.viewmodel.MainActivityContract
import com.example.anhptt.petprojectmanga.activities.main.viewmodel.MainActivityViewModel
import com.example.anhptt.petprojectmanga.activities.fragments.slidemenu.view.SlideMenuFragment
import com.example.anhptt.petprojectmanga.extensions.replaceFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import javax.inject.Inject

@PerActivity
class MainActivity : BaseActivity(), MainActivityContract.Navigator, SlideMenuFragment.SlideMenuCallback {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var slideMenuFragment: SlideMenuFragment
    private var drawerToggle: ActionBarDrawerToggle? = null
    private var mHandler: Handler? = null
    private var itemMenu: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.setLifecycleOwner(this)
        viewModel = ViewModelProviders.of(this@MainActivity, viewModelFactory).get(MainActivityViewModel::class.java)
        setSupportActionBar(toolbar)
        slideMenuFragment = supportFragmentManager
                .findFragmentById(R.id.nav_fragment) as SlideMenuFragment
        slideMenuFragment.setSlideMenuCallback(this)
        initSlideMenu()
    }

    private fun initSlideMenu() {
        setSupportActionBar(mBinding.appBarMain!!.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        drawerToggle = object : ActionBarDrawerToggle(this@MainActivity, mBinding.drawerLayout,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)
                mBinding.appBarMain!!.coordinatorLayout.translationX = slideOffset * drawerView.width
            }
        }
        drawerToggle?.isDrawerIndicatorEnabled = true
        mBinding.drawerLayout.addDrawerListener(drawerToggle!!)
        mHandler = Handler()
        //init home
        goToHome()
    }

    override fun onClick(position: Int) {
        mBinding.drawerLayout.closeDrawer(GravityCompat.START)
        when (position) {
            1 -> goToHome()
            2 -> goToCategory()
            3 -> goToFavorite()
            4 -> goToDownload()
            6 -> goToShare()
            7 -> goToSettings()
            8 -> goToExit()
        }
    }

    override fun goToHome() {
        supportActionBar?.title = getString(R.string.app_name)
        itemMenu?.isVisible = true
        replaceFragment(HomeFragment.newInstance(), R.id.container, HomeFragment.TAG)
    }

    override fun goToCategory() {
        supportActionBar?.title = "Thể Loại"
        itemMenu?.isVisible = true
    }

    override fun goToFavorite() {
        supportActionBar?.title = "Yêu Thích"
        itemMenu?.isVisible = true
    }

    override fun goToDownload() {
        supportActionBar?.title = "Tải Xuống"
        itemMenu?.isVisible = true
    }

    override fun goToShare() {
        supportActionBar?.title = "Chia Sẽ"
        itemMenu?.isVisible = false
    }

    override fun goToSettings() {
        supportActionBar?.title = "Cài Đặt"
        itemMenu?.isVisible = false
    }

    override fun goToExit() {
        itemMenu?.isVisible = false
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        itemMenu = menu.findItem(R.id.action_search)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToggle?.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (drawerToggle?.onOptionsItemSelected(item)!!) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
