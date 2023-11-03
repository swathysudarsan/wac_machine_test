package com.example.sampleappwac.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.sampleappwac.adapter.BannerAdapter
import com.example.sampleappwac.adapter.CategoryAdapter
import com.example.sampleappwac.adapter.ProductAdapter
import com.example.sampleappwac.databinding.FragmentHomeBinding
import com.example.sampleappwac.viewModel.HomeViewModel

class HomeFragment: BaseFragment() {
    override lateinit var viewModel: HomeViewModel
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.getHome()
        viewModel.homeCategoryData.observe(viewLifecycleOwner){
            binding.categoryRecycler.adapter= CategoryAdapter(it?.data)
        }
        viewModel.homeBannerData.observe(viewLifecycleOwner){
            binding.bannerRecycler.adapter= BannerAdapter(it?.data)
        }
        viewModel.homeProductData.observe(viewLifecycleOwner){
            binding.productRecycler.adapter= ProductAdapter(it?.data)
        }

    }
}