package com.example.barkpedia.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Image(
    val height: Int?=null,
    val id: String?=null,
    val url: String?=null,
    val width: Int?=null
): Parcelable