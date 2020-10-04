package com.thideoli.gokinterview.repository.remote

import com.thideoli.gokinterview.repository.remote.response.ProductResponse
import retrofit2.Call

interface ApiHelper {

    fun getProducts(): Call<ProductResponse>

}