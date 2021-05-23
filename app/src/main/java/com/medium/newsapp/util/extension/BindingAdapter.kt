package com.medium.newsapp.util.extension

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("visibleIf")
fun View.visibleIf(state:Boolean){
    visibility = if(state)
        View.VISIBLE
    else
        View.GONE
}

@BindingAdapter("bindUrlImage")
fun ImageView.bindUrlImage(url:String?){
    url?.let {
        Glide.with(this.context).load(it).into(this)
    }
}