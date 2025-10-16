package com.cognitus.courseandroid.model
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class  DogsResponse (@SerializedName("status") @Expose var status:String,
                          @SerializedName("message")@Expose var images: List<String>){}
