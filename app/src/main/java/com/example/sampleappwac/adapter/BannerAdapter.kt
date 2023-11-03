package com.example.sampleappwac.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleappwac.api.HomeResponse
import com.example.sampleappwac.databinding.BannerRecBinding
import com.example.sampleappwac.databinding.RecCategoryLytBinding
import com.example.sampleappwac.util.fetch

class BannerAdapter(val array: List<HomeResponse.HomeResponseItem.Data?>?) : RecyclerView.Adapter<BannerAdapter.VH>() {
    inner class VH(val binding: BannerRecBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
        VH(BannerRecBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun getItemCount(): Int =array?.size?:0
    override fun onBindViewHolder(holder: VH, position: Int) {
        with(holder.binding){
            holder.itemView.apply {
                array?.get(position)?.let {
                    image.fetch(it.image)
                }
            }}
    }
}