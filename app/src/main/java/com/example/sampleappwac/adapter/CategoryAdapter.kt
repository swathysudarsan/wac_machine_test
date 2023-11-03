package com.example.sampleappwac.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleappwac.api.HomeResponse
import com.example.sampleappwac.databinding.RecCategoryLytBinding
import com.example.sampleappwac.util.fetch

class CategoryAdapter(val array: List<HomeResponse.HomeResponseItem.Data?>?) : RecyclerView.Adapter<CategoryAdapter.VH>() {
    inner class VH(val binding: RecCategoryLytBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
        VH(RecCategoryLytBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun getItemCount(): Int = array?.size?:0
    override fun onBindViewHolder(holder: VH, position: Int) {
        with(holder.binding){
            holder.itemView.apply {
                array?.get(position)?.let {
                    textView.text=it.name
                    imageView.fetch(it.image?:it.categoryImage)
                }
            }}
    }
}