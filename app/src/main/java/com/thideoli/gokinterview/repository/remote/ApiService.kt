package com.thideoli.gokinterview.repository.remote

import com.thideoli.gokinterview.repository.remote.response.ProductResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    fun getProducts(): Call<ProductResponse>

}