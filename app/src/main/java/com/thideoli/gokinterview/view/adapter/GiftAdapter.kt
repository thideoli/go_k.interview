package com.thideoli.gokinterview.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.thideoli.gokinterview.R
import com.thideoli.gokinterview.common.DescriptionDialog
import com.thideoli.gokinterview.model.Gift
import kotlinx.android.synthetic.main.item_gift.view.*


class GiftAdapter(private val giftList: List<Gift>) : RecyclerView.Adapter<GiftAdapter.GiftViewHolder>(){

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiftViewHolder {
        mContext = parent.context
        return GiftViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_gift, parent, false))
    }

    override fun getItemCount(): Int = giftList.size

    override fun onBindViewHolder(holderGift: GiftViewHolder, position: Int) {
        val gift = giftList[position]
        Picasso.with(mContext)
            .load(gift.imageURL)
            .error(R.drawable.ic_error_black_56dp)
            .into(holderGift.ivGiftImage)

        holderGift.ivGiftImage.setOnClickListener {
            DescriptionDialog(mContext).showDialog(gift.name, gift.description)
        }
    }

    class GiftViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivGiftImage = view.iv_gift_image
    }
}