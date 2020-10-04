package com.thideoli.gokinterview.model

import com.google.gson.annotations.SerializedName

class Gift(
    @SerializedName("name")
    val name: String?,

    @SerializedName("imageURL")
    val imageURL: String?,

    @SerializedName("description")
    val description: String?
)