package com.example.proyectoparte1_marioherrero.datos

import com.example.proyectoparte1_marioherrero.R
import com.example.proyectoparte1_marioherrero.modelo.Pedido
import com.example.proyectoparte1_marioherrero.modelo.Pizza
import com.example.proyectoparte1_marioherrero.modelo.Precio
import com.example.proyectoparte1_marioherrero.modelo.Usuario

class Data {

    fun cargarUsuario(): Usuario = Usuario(
        id = 1234,
        name = "Mario",
        surname = "Herrero Crucera",
        email = "always.haxe@gmail.com",
        phoneNumber = "+34 611 480 475",
        R.drawable.profilepicture1
    )

    /** --- Precios base --- **/
    fun obtenerPrecios(): Precio = Precio(
        pizzaPequeña = 4.95,
        pizzaMediana = 6.95,
        pizzaGrande = 10.95,
        agua = 2.0,
        cola = 2.5,
        sinBebida = 0.0
    )

    /** --- Lógica de cálculo --- **/
    fun calcularPrecioTotal(
        pizzaSize: String,
        pizzaCount: Int,
        drink: String,
        drinkCount: Int
    ): Double {
        val precios = obtenerPrecios()

        val precioPizza = when (pizzaSize.lowercase()) {
            "pequeña" -> precios.pizzaPequeña
            "mediana" -> precios.pizzaMediana
            "grande" -> precios.pizzaGrande
            else -> 0.0
        }

        val precioBebida = when (drink.lowercase()) {
            "agua" -> precios.agua
            "cola" -> precios.cola
            "sin bebida" -> precios.sinBebida
            else -> 0.0
        }

        return (precioPizza * pizzaCount) + (precioBebida * drinkCount)
    }

    /** --- Lista de pizzas y opciones disponibles --- **/
    fun cargarPizzas(): List<Pizza> = listOf(
        Pizza("Romana", listOf("Con champiñones", "Sin champiñones")),
        Pizza("Barbacoa", listOf("Carne de cerdo", "Pollo", "Ternera")),
        Pizza("Margarita", listOf("Con piña", "Sin piña", "Vegana"))
    )

    /** --- Pedidos de ejemplo --- **/
    fun cargarPedidos(): List<Pedido> = listOf(
        Pedido(
            id = 1,
            date = "25/09/2025",
            pizzaType = "Barbacoa",
            pizzaOptions = "Pollo",
            pizzaSize = "Mediana",
            pizzaCount = 2,
            drink = "Agua",
            drinkCount = 2,
            totalPrice = calcularPrecioTotal("Mediana", 2, "Agua", 2)
        ),
        Pedido(
            id = 2,
            date = "28/09/2025",
            pizzaType = "Margarita",
            pizzaOptions = "Vegana",
            pizzaSize = "Mediana",
            pizzaCount = 2,
            drink = "Agua",
            drinkCount = 1,
            totalPrice = calcularPrecioTotal("Mediana", 2, "Agua", 1)
        ),
        Pedido(
            id = 3,
            date = "02/10/2025",
            pizzaType = "Margarita",
            pizzaOptions = "Con piña",
            pizzaSize = "Grande",
            pizzaCount = 1,
            drink = "Cola",
            drinkCount = 1,
            totalPrice = calcularPrecioTotal("Grande", 1, "Cola", 1)
        ),
        Pedido(
            id = 4,
            date = "05/10/2025",
            pizzaType = "Romana",
            pizzaOptions = "Con champiñones",
            pizzaSize = "Pequeña",
            pizzaCount = 3,
            drink = "Agua",
            drinkCount = 3,
            totalPrice = calcularPrecioTotal("Pequeña", 3, "Agua", 3)
        )
    )
}
