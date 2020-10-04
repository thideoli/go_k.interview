package com.thideoli.gokinterview.repository.remote

import com.thideoli.gokinterview.repository.remote.response.ProductResponse
import retrofit2.Call

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override fun getProducts(): Call<ProductResponse> = apiService.getProducts()

}