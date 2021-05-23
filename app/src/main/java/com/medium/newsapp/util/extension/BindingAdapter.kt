package com.medium.newsapp.util.extension

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("visibleIf")
fun View.visibleIf(state:Boolean){
    visibility = if(state)
        View.VISIBLE
    else
        View.GONE
}