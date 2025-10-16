package com.cognitus.courseandroid

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.cognitus.courseandroid.databinding.ActivityNoticiaBinding
import com.cognitus.courseandroid.model.NewsItem
import com.squareup.picasso.Picasso

class NewContentActivity : Utility(), View.OnClickListener  {

    private var newsItem: NewsItem? = null
    private lateinit var binding: ActivityNoticiaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_new_content)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_new_content)
        binding.clickListener = this
        initializeToolbar(binding.barraPrincipal, "Noticias", back = true, isMain = true)
        binding.barraPrincipal.ivExit.setImageResource(R.drawable.ic_clock)

        // Recupera el objeto NewsItem desde el Intent
        newsItem = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("objetNew", NewsItem::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<NewsItem>("objetNew")
        }
        newsItem?.let {

            val image = findViewById<ImageView>(R.id.news_image)
            val titleNew = findViewById<TextView>(R.id.title_text)
            val contentNew = findViewById<TextView>(R.id.body_text)
            image.loadUrl(it.photoNews)
            titleNew.text = it.titleNews
            contentNew.text = it.descriptionNews
        }
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
    fun ImageView.loadUrl(url: String) {
            Picasso.get().load(url).into(this)
    }
}
