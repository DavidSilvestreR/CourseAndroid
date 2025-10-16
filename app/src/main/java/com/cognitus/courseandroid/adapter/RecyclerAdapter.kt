package com.cognitus.courseandroid.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.cognitus.courseandroid.NewContentActivity
import com.cognitus.courseandroid.R
import com.cognitus.courseandroid.model.NewsItem
import com.squareup.picasso.Picasso

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    var newsItem: MutableList<NewsItem>  = ArrayList()
    lateinit var context: Context

    fun setData(newsItem : MutableList<NewsItem>, context: Context){
        this.newsItem = newsItem
        this.context = context
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = newsItem.get(position)
        holder.bind(item, context)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_news_list, parent, false))

    }
   override fun getItemCount(): Int {
        return newsItem.size
   }
  class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleNews: TextView = view.findViewById(R.id.textViewTitulo)
        val descriptionNews: TextView = view.findViewById(R.id.textViewDescripcion)
        val photoNews: ImageView = view.findViewById(R.id.imageViewNoticia)
      fun bind(newsItem:NewsItem, context: Context){
          titleNews.text = newsItem.titleNews
          descriptionNews.text = newsItem.descriptionNews
          photoNews.loadUrl(newsItem.photoNews)
          itemView.setOnClickListener {
              Toast.makeText(context, newsItem.titleNews, Toast.LENGTH_SHORT).show()
              val intent = Intent(context, NewContentActivity::class.java)
              intent.putExtra("objetNew", newsItem)
              context.startActivity(intent)
          }

      }





      fun ImageView.loadUrl(url: String) {
          Picasso.get().load(url).into(this)
      }

  }
}

