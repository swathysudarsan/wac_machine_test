package com.example.sampleappwac.util

import android.graphics.Paint
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

fun ImageView.fetch(
    url: String?
) {
    Glide
        .with(context)
        .load(url)
        .centerCrop()
        .into(this)
}
fun TextView.showStrikeThrough(show: Boolean) {
    paintFlags =
        if (show) paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        else paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
}