package com.cursoandroidm2.screens.menu

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.cursoandroidm2.databinding.ActivityMainBinding
import com.cursoandroidm2.fcm.viewmodel.FcmViewModel
import com.cursoandroidm2.screens.settings.views.activity.PantallaConfiguracion

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: FcmViewModel by viewModels()

        // Puedes obtener el token llamando a la función del ViewModel
        viewModel.fetchFcmToken()


        binding.btnGoToConfig.setOnClickListener {
            val intent = Intent(this, PantallaConfiguracion::class.java)
            startActivity(intent)
        }
    }

}