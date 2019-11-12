package com.mcs.luel.pictureview.model

import com.mcs.luel.pictureview.presenter.Presenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkCall() {
    fun initRetrofit(presenter: Presenter){
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apicall = retrofit.create<NetworkApi>(NetworkApi::class.java)
        apicall.getPics().enqueue(object: Callback<ArrayList<PictureData>> {
            override fun onFailure(call: Call<ArrayList<PictureData>>, t: Throwable) {
                presenter.sendError(t.message?:"error")

            }

            override fun onResponse(
                call: Call<ArrayList<PictureData>>,
                response: Response<ArrayList<PictureData>>
            ) {
//                presenter.sendData(response.body()?.let { it }!!)
               presenter.sendData(response.body()?: arrayListOf())
            }
        })

    }
}