package com.mcs.luel.pictureview.view

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mcs.luel.pictureview.R
import com.mcs.luel.pictureview.model.PictureData




class CustomAdapter ( val dataset : ArrayList<PictureData>) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view : View = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.item_layout,
                parent,
                false
            )

        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val url = Uri.parse(dataset.get(position).thumbnailUrl)
        Glide.with(holder.itemView.context)
            .load(url)
            .into(holder.thumbenail)
        holder.thumbenail.setOnClickListener({

            val fm = PictureDetailFragment(dataset[position])
            val activity =  holder.itemView.context as? MainActivity
            fm.show(activity!!.supportFragmentManager, "tag")
        })
    }

    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
        val fragmentTransaction = beginTransaction()
        fragmentTransaction.func()
        fragmentTransaction.commit()
    }

    class CustomViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {
        val thumbenail: ImageView = itemView.findViewById(R.id.iv_thumbnail)
    }
}