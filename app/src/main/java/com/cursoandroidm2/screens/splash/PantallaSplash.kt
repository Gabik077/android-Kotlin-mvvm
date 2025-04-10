package com.cursoandroidm2.screens.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.cursoandroidm2.R
import com.cursoandroidm2.Utils
import com.cursoandroidm2.screens.menu.MainActivity
import java.util.Locale
import java.util.Timer
import java.util.TimerTask

class PantallaSplash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_pantalla_splash)

        val sharedPref = getSharedPreferences("preferencias", MODE_PRIVATE)
        val defaultLang = Locale.getDefault().language //idioma por defecto del dispositivo
        val idioma = sharedPref.getString("idioma", defaultLang)

        Utils.setLanguage(idioma ?: defaultLang)

       val task = object : TimerTask() {
            override fun run() {
                val intent = Intent(this@PantallaSplash, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        Timer().schedule(task, 5000)//2 segundos

    }
}