package com.thideoli.gokinterview.repository.remote.response

import com.google.gson.annotations.SerializedName
import com.thideoli.gokinterview.model.Cash
import com.thideoli.gokinterview.model.Gift
import com.thideoli.gokinterview.model.Spotlight

class ProductResponse(
    @SerializedName("spotlight")
    val spotlightList: List<Spotlight>?,

    @SerializedName("products")
    val giftList: List<Gift>?,

    @SerializedName("cash")
    val cash: Cash?
)