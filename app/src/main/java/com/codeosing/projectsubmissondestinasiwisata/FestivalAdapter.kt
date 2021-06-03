package com.codeosing.projectsubmissondestinasiwisata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FestivalAdapter(private val listFestival: ArrayList<Festival>) : RecyclerView.Adapter<FestivalAdapter.AdapterViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_festival, parent, false)
        return AdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        val fest = listFestival[position]
        Glide.with(holder.itemView.context)
            .load(fest.photo)
            .centerCrop()
            .into(holder.imgPhoto)
        holder.tvName.text = fest.name
        holder.tvLocation.text = fest.location
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listFestival[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listFestival.size
    }

    inner class AdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.iv_festival)
        var tvName: TextView = itemView.findViewById(R.id.tv_judul)
        var tvLocation: TextView = itemView.findViewById(R.id.tv_location)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Festival)
    }

}