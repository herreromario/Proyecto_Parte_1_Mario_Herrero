package com.example.proyectoparte1_marioherrero.modelo

import android.hardware.camera2.TotalCaptureResult

data class Pedido(
    val id: Int,
    val date: String,
    val pizzaType: String,
    val pizzaSize: String,
    val pizzaCount: Int,
    val drink: String,
    val drinkCount: Int,
    val totalPrice: Double,
)
