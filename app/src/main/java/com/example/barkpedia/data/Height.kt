package com.example.barkpedia.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Height(
    val imperial: String?=null,
    val metric: String?=null
): Parcelable