package com.example.barkpedia.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DogsItem(
    val bred_for: String?=null,
    val breed_group: String?=null,
    val country_code: String?=null,
    val description: String?=null,
    val height: Height?=null,
    val history: String?=null,
    val id: Int?=null,
    val image: Image?=null,
    val life_span: String?=null,
    val name: String?=null,
    val origin: String?=null,
    val reference_image_id: String?=null,
    val temperament: String?=null,
    val weight: Weight?=null
): Parcelable