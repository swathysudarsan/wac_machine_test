package com.example.sampleappwac.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleappwac.api.HomeResponse
import com.example.sampleappwac.databinding.BannerRecBinding
import com.example.sampleappwac.databinding.ProductLytBinding
import com.example.sampleappwac.util.fetch
import com.example.sampleappwac.util.showStrikeThrough

class ProductAdapter(val array: List<HomeResponse.HomeResponseItem.Data?>?): RecyclerView.Adapter<ProductAdapter.VH>() {
    inner class VH(val binding: ProductLytBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
        VH(ProductLytBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun getItemCount(): Int =array?.size?:0
    override fun onBindViewHolder(holder: VH, position: Int) {
        with(holder.binding){
            holder.itemView.apply {
                array?.get(position)?.let {
                prodImg.fetch(it.image)
                    prodName.text=it.name
                    if (it.isExpress==true){
                        cartImg.visibility=View.VISIBLE
                    }else{
                        cartImg.visibility=View.INVISIBLE
                    }
                    if (it.offerPercentage!! > 0){
                        offer.visibility=View.VISIBLE
                        offer.text=it.offerPercentage.toString()+"% OFF"
                    }else{
                        offer.visibility=View.GONE
                    }

                    offerPrice.text="₹"+it.offerPrice.toString()
                    actualPrice.text="₹"+it.actualPrice.toString()

                    if (it.offerPrice==it.actualPrice){
                        actualPrice.visibility=View.INVISIBLE
                    }else
                    {
                        actualPrice.showStrikeThrough(true)
                    }

                }
            }}
    }
}