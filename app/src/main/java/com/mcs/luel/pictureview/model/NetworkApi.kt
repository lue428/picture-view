package com.mcs.luel.pictureview.model

import retrofit2.Call
import retrofit2.http.GET

interface NetworkApi {

    @GET("photos")
    fun getPics(): Call<ArrayList<PictureData>>
}