package com.example.sampleappwac.api


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

class HomeResponse : ArrayList<HomeResponse.HomeResponseItem>(){
    @Entity
    data class HomeResponseItem(
        @SerializedName("data")
        var `data`: List<Data?>?,
        @SerializedName("type")
        var type: String?
    ) {
        @Entity
        data class Data(
            @SerializedName("actualPrice")
            var actualPrice: Int?,
            @SerializedName("categoryImage")
            var categoryImage: String?,
            @SerializedName("description")
            var description: String?,
            @SerializedName("id")
            var id: String?,
            @SerializedName("image")
            var image: String?,
            @SerializedName("isExpress")
            var isExpress: Boolean?,
            @SerializedName("name")
            var name: String?,
            @SerializedName("offerPercentage")
            var offerPercentage: Int?,
            @SerializedName("offerPrice")
            var offerPrice: Int?
        )
    }
}