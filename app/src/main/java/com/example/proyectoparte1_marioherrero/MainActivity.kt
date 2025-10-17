package com.example.proyectoparte1_marioherrero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.proyectoparte1_marioherrero.ui.theme.ProyectoParte1MarioHerreroTheme
import com.example.proyectoparte1_marioherrero.ui.theme.RealizarPedido

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoParte1MarioHerreroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RealizarPedido(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}



