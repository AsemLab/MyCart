package com.asemlab.mycart.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Category(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null
)