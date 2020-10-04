package com.thideoli.gokinterview.model

import com.google.gson.annotations.SerializedName

class Cash(
    @SerializedName("title")
    val title: String?,

    @SerializedName("bannerURL")
    val bannerURL: String?,

    @SerializedName("description")
    val description: String?
)