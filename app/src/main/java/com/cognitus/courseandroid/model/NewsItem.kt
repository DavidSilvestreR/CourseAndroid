package com.cognitus.courseandroid.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class NewsItem(
    var titleNews:String,
    var descriptionNews:String,
    var photoNews:String
): Parcelable
