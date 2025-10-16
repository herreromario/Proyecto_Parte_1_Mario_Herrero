package com.example.proyectoparte1_marioherrero.datos

import com.example.proyectoparte1_marioherrero.R
import com.example.proyectoparte1_marioherrero.modelo.Pedido
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

    fun cargarPedidos(): List<Pedido> = listOf(
        Pedido(
            id = 1,
            date = "25/09/2025",
            pizzaType = "Barbacoa",
            pizzaSize = "Mediana",
            pizzaCount = 2,
            drink = "Agua",
            drinkCount = 2,
            totalPrice = 17.9
        ),

        Pedido(
            id = 2,
            date = "28/09/2025",
            pizzaType = "Margarita",
            pizzaSize = "Mediana",
            pizzaCount = 2,
            drink = "Agua",
            drinkCount = 1,
            totalPrice = 15.9
        ),

        Pedido(
            id = 3,
            date = "02/10/2025",
            pizzaType = "Margarita",
            pizzaSize = "Grande",
            pizzaCount = 1,
            drink = "Cola",
            drinkCount = 1,
            totalPrice = 13.45
        ),

        Pedido(
            id = 4,
            date = "02/10/2025",
            pizzaType = "Barbacoa",
            pizzaSize = "Grande",
            pizzaCount = 1,
            drink = "Agua",
            drinkCount = 2,
            totalPrice = 14.95
        ),

        Pedido(
            id = 5,
            date = "05/10/2025",
            pizzaType = "Romana",
            pizzaSize = "Pequeña",
            pizzaCount = 5,
            drink = "Agua",
            drinkCount = 5,
            totalPrice = 34.75
        ),

        Pedido(
            id = 6,
            date = "07/10/2025",
            pizzaType = "Barbacoa",
            pizzaSize = "Grande",
            pizzaCount = 2,
            drink = "Sin refresco",
            drinkCount = 0,
            totalPrice = 10.95
        ),

        Pedido(
            id = 7,
            date = "07/10/2025",
            pizzaType = "Margarita",
            pizzaSize = "Pequeña",
            pizzaCount = 1,
            drink = "Cola",
            drinkCount = 1,
            totalPrice = 7.45
        ),

        Pedido(
            id = 8,
            date = "15/10/2025",
            pizzaType = "Romana",
            pizzaSize = "Mediana",
            pizzaCount = 2,
            drink = "Agua",
            drinkCount = 2,
            totalPrice = 17.9
        ),
    )
}