package com.cognitus.courseandroid

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.cognitus.courseandroid.databinding.ActivityMenuBinding

class MenuActivity  : Utility() , View.OnClickListener {
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.barraPrincipal.clickListener=this
        initializeToolbar(binding.barraPrincipal, "Menu Principal", back = false, isMain = true)

        binding.checkIn.setOnClickListener(this)
        binding.taskMenu.setOnClickListener(this)
        binding.notificationMenu.setOnClickListener(this)
        binding.newsMenu.setOnClickListener(this)
        binding.profileMenu.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()
        when (v?.id) {
            R.id.ivExit -> {

                AlertDialogCustom.createSimpleAlert(
                    this,
                    "Sesión",
                    "¿Estás seguro de cerrar sesión?", logoInferior = true,
                    logoSuperior = true
                )

            }
            R.id.checkIn -> {
                Toast.makeText(this, "Check In", Toast.LENGTH_SHORT).show()
            }
            R.id.task_menu -> {
                val intent = Intent(this, DogActivity::class.java)
                startActivity(intent)
                finish()
            }
            R.id.notification_menu -> {
                Toast.makeText(this, "Notificaciones", Toast.LENGTH_SHORT).show()
            }
            R.id.news_menu -> {
                val intent = Intent(this, NoticiaActivity::class.java)
                startActivity(intent)
                finish()
            }
            R.id.profile_menu -> {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}