package com.cognitus.courseandroid

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.content.edit
import androidx.core.graphics.drawable.toDrawable
import com.cognitus.courseandroid.databinding.DialogAlertBinding

object AlertDialogCustom {
    private fun createAlert(context: Context,
                            title: String?,
                            message: String,
                            logoInferior: Boolean, logoSuperior: Boolean) {
        val builder = AlertDialog.Builder(context)
        val binding = DialogAlertBinding.inflate(LayoutInflater.from(context))
        binding.titulo = title
        binding.texto = message
        binding.logoInferior = logoInferior
        binding.logoSuperior = logoSuperior
        builder.setView(binding.root)
        val d = builder.create()
        d.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())

        binding.txtPositive =context.getString(R.string.txt_positive)
        binding.txtNegative =context.getString(R.string.txt_negative)
        binding.clickListenerPositive = View.OnClickListener {
            val sharedPreference =  (context as Activity).getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
            sharedPreference.edit {
                clear()
                remove("username")
            }
            context.finishAffinity()
            d.dismiss()
        }
        binding.clickListenerNegative = View.OnClickListener {
            d.dismiss()
        }

        d.setCancelable(false)
        d.setCanceledOnTouchOutside(false)
        d.show()
    }



    fun createSimpleAlert(
        context: Context,
        title: String,
        message: String,
        logoInferior: Boolean = false,
        logoSuperior: Boolean = false) {
        createAlert(
            context, title, message,
            logoInferior,logoSuperior
        )
    }
    
}