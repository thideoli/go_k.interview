package com.thideoli.gokinterview.repository

import com.thideoli.gokinterview.repository.remote.ApiHelper

class Repository(private val apiHelper: ApiHelper) {
    fun getProducts() = apiHelper.getProducts()
}