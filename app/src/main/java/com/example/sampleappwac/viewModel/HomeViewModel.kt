package com.example.sampleappwac.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.sampleappwac.api.HomeResponse
import com.example.sampleappwac.api.RetrofitClient
import com.example.sampleappwac.application.Application
import kotlinx.coroutines.launch

class HomeViewModel:BaseViewModel() {

    val homeCategoryData: MutableLiveData<HomeResponse.HomeResponseItem?> = MutableLiveData()
    val homeBannerData: MutableLiveData<HomeResponse.HomeResponseItem?> = MutableLiveData()
    val homeProductData: MutableLiveData<HomeResponse.HomeResponseItem?> = MutableLiveData()


    fun getHome(){

        viewModelScope.launch {
            try {
                showLoader.value=true
                val response= RetrofitClient.apiService.getHomeData()
                homeCategoryData.value=response.get(0)
                homeBannerData.value=response.get(1)
                homeProductData.value=response.get(2)
                Application.appDatabase.userDao().insertUser(response)

                showLoader.value=false
            } catch (e: Exception) {
                e.printStackTrace()
                showLoader.value=false
            }

        }
    }


}