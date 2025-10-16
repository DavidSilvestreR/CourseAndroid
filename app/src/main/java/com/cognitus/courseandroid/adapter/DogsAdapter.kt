package com.cognitus.courseandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cognitus.courseandroid.databinding.ItemDogBinding
import com.squareup.picasso.Picasso

class DogsAdapter (var context: Context, var list: List<String>):
    RecyclerView.Adapter<DogsAdapter.ViewHolder>() {

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater  = LayoutInflater.from(parent.context)
        val bind = ItemDogBinding.inflate(inflater,parent,false)
        return ViewHolder(bind)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }
    inner class ViewHolder(val binding: ItemDogBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(image: String) {
            binding.executePendingBindings()
            Picasso.get().load(image).into(binding.ivDog)
        }
    }
}