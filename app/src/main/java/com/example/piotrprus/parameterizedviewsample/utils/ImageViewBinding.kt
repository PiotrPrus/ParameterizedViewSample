package com.example.piotrprus.parameterizedviewsample.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("srcImage")
fun ImageView.setSrcImage(resourceId: Int) = setImageResource(resourceId)