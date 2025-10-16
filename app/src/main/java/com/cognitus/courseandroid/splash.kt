package com.cognitus.courseandroid

import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val splashImage = findViewById<ImageView>(R.id.splash_image)

        val scaleXUp = ObjectAnimator.ofFloat(splashImage, "scaleX", 1f, 1.2f)
        val scaleYUp = ObjectAnimator.ofFloat(splashImage, "scaleY", 1f, 1.2f)
        scaleXUp.duration = 1000
        scaleYUp.duration = 1000

        val scaleXDown = ObjectAnimator.ofFloat(splashImage, "scaleX", 1.2f, 1f)
        val scaleYDown = ObjectAnimator.ofFloat(splashImage, "scaleY", 1.2f, 1f)
        scaleXDown.duration = 500
        scaleYDown.duration = 500

        scaleXUp.start()
        scaleYUp.start()

        Handler(Looper.getMainLooper()).postDelayed({
            scaleXDown.start()
            scaleYDown.start()
        }, 1000)


        Handler(Looper.getMainLooper()).postDelayed({
            val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
            val username = sharedPreference.getString("username", "0")

            if (username != "0" && username != null) {
                // User is logged in, go to Menu
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
            } else {
                // User is not logged in, go to Login
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            finish()
        }, 1500)
    }
}