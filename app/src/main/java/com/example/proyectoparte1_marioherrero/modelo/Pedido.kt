package com.example.proyectoparte1_marioherrero.modelo

data class Pedido(
    val id: Int,
    val date: String,
    val pizzaType: String,
    val pizzaOptions: String? = null,
    val pizzaSize: String,
    val pizzaCount: Int,
    val drink: String,
    val drinkCount: Int,
    val totalPrice: Double,
)
