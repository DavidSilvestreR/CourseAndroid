package com.cognitus.courseandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cognitus.courseandroid.adapter.RecyclerAdapter
import com.cognitus.courseandroid.databinding.ActivityNoticiaBinding
import com.cognitus.courseandroid.model.NewsItem

class NoticiaActivity : Utility(), View.OnClickListener  {
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityNoticiaBinding>(this, R.layout.activity_noticia)
    }
    lateinit var mRecyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var mRecyclerView : RecyclerView
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding.clickListener = this
        initializeToolbar(binding.barraPrincipal, "Noticias", back = true, isMain = false)

        val mAdapter : RecyclerAdapter = RecyclerAdapter()
        mRecyclerView = binding.rvNewItemList
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.setData(getNewsList(), this)
        mRecyclerView.adapter = mAdapter
    }


    private fun getNewsList(): MutableList<NewsItem> {
        var newsItem: MutableList<NewsItem> = ArrayList()
        newsItem.add(NewsItem("Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", "https://www.elfinanciero.com.mx/resizer/v2/YUJHJYRIGVE4HIR3NWLP2OFHWQ.jpg?smart=true&auth=ef0af7abcda5ad6f00ae55bcfe2ce7b7a12d574419bc23464bc6eae3ea8a1ea3&width=1200&height=675&quality=85"))
        newsItem.add(NewsItem("Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", "https://ichef.bbci.co.uk/ace/ws/800/cpsprodpb/9a67/live/06567ad0-a93f-11f0-a207-37a46608d8d7.jpg.webp"))
        newsItem.add(NewsItem("Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", "https://www.elfinanciero.com.mx/resizer/v2/PB5PMEBS45FA3CV5DQHSBIFVZY.jpg?smart=true&auth=5596434c7ba11afeb2294fe54dca7ac73bf9c4dff7feaaa173faf6280e5808fe&width=1200&height=675&quality=85"))
        newsItem.add(NewsItem("Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", "https://www.elfinanciero.com.mx/resizer/v2/6NN42DT4M5E7FFJX2GYLQ7RH4I.jpg?smart=true&auth=bd23f1082f60d55ba7605573baf1af46b95df8152eed82443fa3813d68e9ea84&width=1200&height=675&quality=85"))
        newsItem.add(NewsItem("Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", "https://www.foxsports.com.mx/resizer/v2/NN4YSPDFIJGYLJ3IPGRNE34UEE.jpg?smart=true&auth=8fdc09232c44c8475703513b8cb9a5bc7df6d21373f65eb8b66b73a580d3d4cc&width=1200&height=675&quality=85"))
        newsItem.add(NewsItem("Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", "https://www.elfinanciero.com.mx/resizer/v2/C4TXPHSWTJHDZM5DCAHKPFSSGI.jpg?smart=true&auth=b22d88377fa9ebd2f13973e7020059c532de0aeb4a2494e32add7d5a05d833ff&width=1200&height=675&quality=85"))
        return newsItem
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ivExit -> {
               val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        TODO("Not yet implemented")
    }
}