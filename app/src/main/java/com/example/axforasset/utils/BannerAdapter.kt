package com.example.axforasset.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.axforasset.databinding.CarouselItemBinding
import com.example.axforasset.models.BannerModel

class BannerAdapter(private var bannerList: List<BannerModel>): RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {
    class BannerViewHolder(val binding: CarouselItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val binding = CarouselItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val banner = bannerList[position]
        holder.binding.apply {
            bannerIv.setImageResource(banner.image)
        }
    }

    override fun getItemCount(): Int = bannerList.size
}