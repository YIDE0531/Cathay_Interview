package com.nuu.cathay_interview.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter(
    "srcUrl",
    requireAll = false // make the attributes optional
)
fun ImageView.bindSrcUrl(
    url: String?,
) = Glide.with(this).load(url).let { request ->

//    if (circleCrop) {
//        request.circleCrop()
//    }
//
//    if (placeholder != null) {
//        request.placeholder(placeholder)
//    }

    request.into(this)
}