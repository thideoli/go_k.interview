package com.thideoli.gokinterview.view

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import com.thideoli.gokinterview.R
import com.thideoli.gokinterview.common.DescriptionDialog
import com.thideoli.gokinterview.common.GeneralDialog
import com.thideoli.gokinterview.util.Status
import com.thideoli.gokinterview.view.adapter.GiftAdapter
import com.thideoli.gokinterview.view.adapter.SpotlightAdapter
import com.thideoli.gokinterview.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val mMainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupObserver()
    }

    private fun setupUI() {

        fl_loading.visibility = View.VISIBLE

        rv_spotlight.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_gift.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        tv_user_name.text = getString(R.string.greeting, "Thiago")

    }

    private fun setupObserver() {
        mMainViewModel.products.observe(this, Observer { resource ->
            when (resource.status) {
                Status.SUCCESS -> {

                    val _spotlightList = resource.data?.spotlightList
                    val _cash = resource.data?.cash
                    val _giftList = resource.data?.giftList

                    _spotlightList?.let { spotlightList ->
                        rv_spotlight.adapter = SpotlightAdapter(spotlightList)
                    }

                    _cash?.let { cash ->
                        Picasso.with(applicationContext)
                            .load(cash.bannerURL)
                            .error(R.drawable.ic_error_black_56dp)
                            .into(iv_cash_image)

                        iv_cash_image.setOnClickListener {
                            DescriptionDialog(this).showDialog(cash.title, cash.description)
                        }
                    }

                    _giftList?.let { giftList ->
                        rv_gift.adapter = GiftAdapter(giftList)
                    }

                    fl_loading.visibility = View.GONE
                }
                Status.LOADING -> {
                    fl_loading.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    GeneralDialog(this).showDialog(description = resource.message, positiveButtonText = getString(
                                            R.string.try_again), positiveButtonCallback = positiveButtonClick())
                }
            }
        })
    }

    private fun positiveButtonClick(): DialogInterface.OnClickListener {
        return DialogInterface.OnClickListener { dialog, id ->
            mMainViewModel.fetchProducts()
            dialog.dismiss()
        }
    }
}
