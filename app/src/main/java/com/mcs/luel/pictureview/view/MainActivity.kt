package com.mcs.luel.pictureview.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.google.android.material.snackbar.Snackbar
import com.mcs.luel.pictureview.R
import com.mcs.luel.pictureview.model.PictureData
import com.mcs.luel.pictureview.presenter.Presenter
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Class

class MainActivity : AppCompatActivity(), viewContract {

    lateinit var presenter : Presenter
    lateinit var adapter: CustomAdapter
    override fun initUI() {
        val layoutManager  = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager
    }

    override fun initPresenter() {
        presenter = Presenter()
        presenter.initView(this)
    }

    override fun passPicturedata(dataset: ArrayList<PictureData>) {
        adapter = CustomAdapter(dataset)
        recyclerView.adapter = adapter
    }

    override fun getErrorMessage(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initPresenter()
        initUI()
        btn_favs.setOnClickListener {
            startActivity(Intent(this, FavoritesActivity::Class.java))

        }
    }
}
