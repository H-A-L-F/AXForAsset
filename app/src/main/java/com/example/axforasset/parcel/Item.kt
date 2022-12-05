package com.example.axforasset.parcel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Item(
    val image: Int,
    val title: String,
    val desc: String
): Parcelable