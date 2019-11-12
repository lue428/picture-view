package com.mcs.luel.pictureview.view

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.mcs.luel.pictureview.R
import com.mcs.luel.pictureview.model.PictureData
import kotlinx.android.synthetic.main.fragment_activity.*

class PictureDetailFragment(val data : PictureData) : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val url = Uri.parse(data.url)
        Glide.with(this)
            .load(url)
            .into(iv_picture)
            //tv_detail.setText(data.title)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val view : View = inflater.inflate(R.layout.fragment_activity, container, false)

        return view
    }

}