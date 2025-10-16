package com.cognitus.courseandroid

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btnLogin : Button = findViewById<Button>(R.id.btn_login)
        val forget : TextView = findViewById<TextView>(R.id.link_forget)
        val register : TextView = findViewById<TextView>(R.id.link_register)
        val etUser: EditText = findViewById(R.id.et_user)
        val builder = AlertDialog.Builder(this)
        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()
        builder.setTitle("Mensaje del sistema")
        builder.setMessage("Debes de colocar datos")

        builder.setPositiveButton(android.R.string.yes) { dialog, which ->
            Toast.makeText(applicationContext,
                android.R.string.yes, Toast.LENGTH_SHORT).show()
        }
//boton cancelar
        builder.setNegativeButton(android.R.string.no) { dialog, which ->

        }
//boton tal vez
        builder.setNeutralButton("Tal vez") { dialog, which ->
            Toast.makeText(applicationContext,
                "Tal vez", Toast.LENGTH_SHORT).show()
        }


        btnLogin.setOnClickListener {
            if (etUser.text.toString().isNotEmpty()) {
                val intent = Intent(this, MenuActivity::class.java)
                editor.putString("username",etUser.text.toString())
                editor.apply()
                startActivity(intent)
                finish()
            } else {
                builder.show()
            }
        }
        forget.setOnClickListener {
            val intent = Intent(this, ForgetPassword::class.java)
            startActivity(intent)
            finish()
        }
        register.setOnClickListener {
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
            finish()
        }



    }
}