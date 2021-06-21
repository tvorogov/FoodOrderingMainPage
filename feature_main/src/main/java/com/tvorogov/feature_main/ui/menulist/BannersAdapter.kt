package com.tvorogov.feature_main.ui.menulist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tvorogov.feature_main.databinding.ItemBannerBinding


class BannersAdapter(private val bannersList: List<Int>) : RecyclerView.Adapter<BannersAdapter.BannersViewHolder>() {

    class BannersViewHolder(private val binding: ItemBannerBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(item: Int) {
            binding.imageBanner.setBackgroundResource(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannersViewHolder {
        val binding = ItemBannerBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return BannersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BannersViewHolder, position: Int) {

        val currentItem = bannersList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return bannersList.size
    }
}

