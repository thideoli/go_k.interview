package com.thideoli.gokinterview.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.thideoli.gokinterview.R
import com.thideoli.gokinterview.common.DescriptionDialog
import com.thideoli.gokinterview.model.Spotlight
import kotlinx.android.synthetic.main.item_spotlight.view.*


class SpotlightAdapter(private val spotlightList: List<Spotlight>) : RecyclerView.Adapter<SpotlightAdapter.SpotlightViewHolder>(){

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpotlightViewHolder {
        mContext = parent.context
        return SpotlightViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_spotlight, parent, false))
    }

    override fun getItemCount(): Int = spotlightList.size

    override fun onBindViewHolder(holderSpotlight: SpotlightViewHolder, position: Int) {
        val spotlight = spotlightList[position]
        Picasso.with(mContext)
            .load(spotlight.bannerURL)
            .error(R.drawable.ic_error_black_56dp)
            .into(holderSpotlight.ivSpotlightBanner)

        holderSpotlight.ivSpotlightBanner.setOnClickListener {
            DescriptionDialog(mContext).showDialog(spotlight.name, spotlight.description)
        }
    }

    class SpotlightViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivSpotlightBanner = view.iv_spotlight_banner
    }
}