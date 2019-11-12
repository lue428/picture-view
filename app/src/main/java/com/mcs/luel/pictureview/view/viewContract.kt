package com.mcs.luel.pictureview.view

import com.mcs.luel.pictureview.model.PictureData

interface viewContract {

    fun initUI()
    fun initPresenter()
    fun passPicturedata(dataset: ArrayList<PictureData>)
    fun getErrorMessage(errorMessage: String)
}