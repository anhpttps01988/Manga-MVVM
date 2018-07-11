package com.example.anhptt.petprojectmanga.utils.widget

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.animation.Interpolator
import android.widget.Scroller

class ViewPagerCustomDuration(context: Context, attributeSet: AttributeSet) : ViewPager(context, attributeSet) {

    private var mScroller: ScrollerCustomDuration? = null

    init {
        postInitViewPager()
    }


    private fun postInitViewPager() {
        try {
            val scroller = ViewPager::class.java.getDeclaredField("mScroller")
            scroller.isAccessible = true
            val interpolator = ViewPager::class.java.getDeclaredField("sInterpolator")
            interpolator.isAccessible = true

            mScroller = ScrollerCustomDuration(context,
                    interpolator.get(null) as Interpolator)
            scroller.set(this, mScroller)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * Set the factor by which the duration will change
     */
    fun setScrollDurationFactor(scrollFactor: Double) {
        mScroller!!.setScrollDurationFactor(scrollFactor)
    }

    inner class ScrollerCustomDuration(context: Context?, interpolator: Interpolator) : Scroller(context) {
        private var mScrollFactor = 1.0


        fun setScrollDurationFactor(scrollFactor: Double) {
            this.mScrollFactor = scrollFactor
        }

        override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int, duration: Int) {
            super.startScroll(startX, startY, dx, dy, (duration * mScrollFactor).toInt())
        }

    }


}