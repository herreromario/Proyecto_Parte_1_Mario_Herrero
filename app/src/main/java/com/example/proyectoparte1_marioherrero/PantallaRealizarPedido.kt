package com.example.proyectoparte1_marioherrero.ui.theme


import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.proyectoparte1_marioherrero.datos.Data


@Composable
fun RealizarPedido(modifier: Modifier = Modifier){
    val precios = Data().obtenerPrecios()
    val pizzas = Data().cargarPizzas()

    /** --- Variables de estado básicas --- **/

    var tipoPizza by remember { mutableStateOf("Barbacoa") }
    var opcionPizza by remember { mutableStateOf("") }
    var tamañoPizza by remember { mutableStateOf("Mediana") }
    var cantidadPizza by remember { mutableIntStateOf(1) }
    var bebida by remember { mutableStateOf("Agua") }
    var cantidadBebida by remember { mutableIntStateOf(1) }

    /** --- Actualización manual del precio --- **/


}


