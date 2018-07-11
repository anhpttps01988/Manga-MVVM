package com.example.anhptt.petprojectmanga.common.adapter

import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.widget.ImageView

object VectorImageBinding {

    @BindingAdapter("app:srcVector")
    @JvmStatic
    fun setSrcVector(view: ImageView, @DrawableRes drawable: Int?) {
        if (drawable != null){
            view.setImageResource(drawable)
        }
    }


}