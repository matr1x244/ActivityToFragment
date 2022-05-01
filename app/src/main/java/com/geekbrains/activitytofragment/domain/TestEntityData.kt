package com.geekbrains.activitytofragment.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TestEntityData(
    var textId: String,
    val textView: String,
    val textNumber: Int
) : Parcelable
