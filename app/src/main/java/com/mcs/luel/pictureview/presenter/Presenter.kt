package com.mcs.luel.pictureview.presenter

import android.view.View
import com.mcs.luel.pictureview.model.NetworkCall
import com.mcs.luel.pictureview.model.PictureData
import com.mcs.luel.pictureview.view.viewContract

class Presenter {
    fun sendError(errorMessage: String) {
        view?.getErrorMessage(errorMessage)
    }

    var view: viewContract?= null

    fun initView(view : viewContract) {
        this.view = view
        NetworkCall().initRetrofit(this)
    }

    fun destroyView() {
        view = null

    }

    fun sendData(dataset: ArrayList<PictureData>) {
        view?.passPicturedata(dataset)

    }

}