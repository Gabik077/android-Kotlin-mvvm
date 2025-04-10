package com.cursoandroidm2.screens.settings.views.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.cursoandroidm2.Utils
import com.cursoandroidm2.databinding.ActivityPantallaConfiguracionBinding
import com.cursoandroidm2.screens.menu.MainActivity
import java.util.Locale

class PantallaConfiguracion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityPantallaConfiguracionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("preferencias", MODE_PRIVATE)
        val defaultLang = Locale.getDefault().language //idioma por defecto del dispositivo
        val idioma = sharedPref.getString("idioma", defaultLang)

        if (idioma == "en") {
            binding.chkIngles.isChecked = true
        } else {
            binding.chkEspanol.isChecked = true

        }

        Utils.setLanguage(idioma ?: defaultLang)

        Log.d("idioma", idioma.toString())

        binding.chkIngles.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.chkEspanol.isChecked = false

            }
        }

        binding.chkEspanol.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.chkIngles.isChecked = false
            }
        }

        binding.btnGuardarConfig.setOnClickListener {

            if(binding.chkIngles.isChecked){
                //guardar en preferencias idioma ingles
                guardarIdioma("en")

            }else{
                //guardar en preferencias idioma español
                guardarIdioma("es")

            }
        }

    }


        private fun guardarIdioma(language: String) {
        //cambiar idioma de la app
        val sharedPref = getSharedPreferences("preferencias", MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("idioma", language)
        editor.apply()

            Utils.setLanguage(language)

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}