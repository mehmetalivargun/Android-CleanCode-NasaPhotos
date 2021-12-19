package com.mehmetalivargun.quotes.extensions

import android.net.Uri
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("imageUrl")
fun ImageView.loadImage(imageUrl: String?) {
    if (imageUrl.isNullOrEmpty()) return

    val uri = Uri.parse(imageUrl)


    Glide.with(context)
        .load(uri)
        .thumbnail(0.05f)
        .into(this)
}
