package com.example.anhptt.petprojectmanga.activities.fragments.home.adapter

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide


object ImageBinding {

    @BindingAdapter("app:srcImage")
    @JvmStatic
    fun setImageFromGlide(imageView: ImageView, pictureUrl: String?) {
        if (pictureUrl != null) {
            Glide.with(imageView.context).load(pictureUrl).into(imageView)
        }
    }

}