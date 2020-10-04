package com.thideoli.gokinterview.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thideoli.gokinterview.R
import com.thideoli.gokinterview.repository.Repository
import com.thideoli.gokinterview.repository.remote.response.ProductResponse
import com.thideoli.gokinterview.util.NetworkHelper
import com.thideoli.gokinterview.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(
    private val application: Application,
    private val repository: Repository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _products = MutableLiveData<Resource<ProductResponse>>()
    val products: LiveData<Resource<ProductResponse>>
        get() = _products

    init {
        fetchProducts()
    }

    fun fetchProducts() {
        viewModelScope.launch {
            _products.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {

                repository.getProducts().enqueue(object : Callback<ProductResponse> {
                    override fun onResponse(
                        call: Call<ProductResponse>?,
                        response: Response<ProductResponse>
                    ) {
                        _products.postValue(Resource.success(response.body()))
                    }

                    override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                        var message = application.getString(R.string.unknown_error)
                        t.message?.let { _message ->
                            message = _message
                        }
                        _products.postValue(Resource.error(message, null))
                    }

                })
            } else _products.postValue(
                Resource.error(
                    application.getString(R.string.no_internet_connection),
                    null
                )
            )
        }
    }

}