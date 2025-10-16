package com.cognitus.courseandroid

import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cognitus.courseandroid.adapter.DogsAdapter
import com.cognitus.courseandroid.databinding.ActivityDogBinding
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.cognitus.courseandroid.model.APIService
import com.cognitus.courseandroid.model.DogsResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DogActivity : Utility(), View.OnClickListener  {
    lateinit var imagesPuppies: List<String>
    lateinit var dogsAdapter: DogsAdapter
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityDogBinding>(this, R.layout.activity_dog)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeToolbar(binding.barraP, "Dogs", back = true, isMain = false)
        binding.barraP.ivExit.setOnClickListener(this)
        binding.btnSearch.setOnClickListener {
            searchByName(binding.searchBreed.text.toString().lowercase() )
        }
    }


    private fun searchByName(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getCharacterByName("$query/images").execute()
            val puppies = call.body() as DogsResponse?
            runOnUiThread {
                if (puppies?.status == "success") {
                    initCharacter(puppies)
                } else {
                    showErrorDialog()
                }
                hideKeyboard()
            }
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun initCharacter(puppies: DogsResponse) {
        if (puppies.status == "success") {
            imagesPuppies = puppies.images
        } else {
            Toast.makeText(this,"Sin datos", Toast.LENGTH_LONG).show()
        }
        dogsAdapter = DogsAdapter(this, imagesPuppies)
        binding.rvDogs.setHasFixedSize(true)
        binding.rvDogs.layoutManager = LinearLayoutManager(this)
        binding.rvDogs.adapter = dogsAdapter
    }

    private fun showErrorDialog() {
        Toast.makeText(this,"Ha ocurrido un error, inténtelo de nuevo.", Toast.LENGTH_LONG).show()
    }
    private fun hideKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ivExit -> {
                val intent = Intent(this, MenuActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        }
    }
}
