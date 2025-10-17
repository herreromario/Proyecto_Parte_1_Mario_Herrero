package com.example.proyectoparte1_marioherrero.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectoparte1_marioherrero.datos.Data

@Composable
fun RealizarPedido(modifier: Modifier = Modifier) {

    val data = Data()
    val precios = data.obtenerPrecios()

    // -------------------------------
    // VARIABLES DE ESTADO
    // -------------------------------
    var tipoPizza by remember { mutableStateOf("Barbacoa") }
    var opcionPizza by remember { mutableStateOf("") }
    var tamañoPizza by remember { mutableStateOf("Mediana") }
    var cantidadPizza by remember { mutableIntStateOf(1) }
    var bebida by remember { mutableStateOf("Agua") }
    var cantidadBebida by remember { mutableIntStateOf(1) }

    // -------------------------------
    // CÁLCULO DEL PRECIO TOTAL
    // -------------------------------
    val precioTotal by remember(
        tipoPizza, opcionPizza, tamañoPizza, cantidadPizza, bebida, cantidadBebida
    ) {
        mutableStateOf(
            data.calcularPrecioTotal(
                pizzaSize = tamañoPizza,
                pizzaCount = cantidadPizza,
                drink = bebida,
                drinkCount = cantidadBebida
            )
        )
    }

    // -------------------------------
    // COLORES PERSONALIZADOS
    // -------------------------------
    val rojoPrincipal = Color(0xFFE53935)
    val grisClaro = Color(0xFFF5F5F5)
    val marronCola = Color(0xFF795548)

    // Distribución general: el contenido principal y el precio abajo fijo
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween, // separa el contenido y el precio
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // CONTENIDO PRINCIPAL

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // --- Título ---
            Text(
                text = "🍕 Realizar pedido",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = rojoPrincipal,
                modifier = Modifier.padding(bottom = 10.dp)
            )

            // --- Tipo de pizza ---
            Text("Selecciona tu pizza", fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(8.dp))

            val tiposPizza = listOf(
                "Barbacoa" to Color(0xFFFF7043),
                "Romana" to Color(0xFF66BB6A),
                "Margarita" to Color(0xFF42A5F5)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                tiposPizza.forEach { (nombre, color) ->
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(if (tipoPizza == nombre) color else grisClaro)
                            .clickable { tipoPizza = nombre }
                            .padding(horizontal = 14.dp, vertical = 8.dp)
                    ) {
                        Text(
                            text = nombre,
                            color = if (tipoPizza == nombre) Color.White else Color.Black,
                            fontWeight = if (tipoPizza == nombre) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // --- Opciones según tipo de pizza ---
            val opcionesPizza = when (tipoPizza) {
                "Barbacoa" -> listOf("Carne de cerdo", "Pollo", "Ternera")
                "Romana" -> listOf("Con champiñones", "Sin champiñones")
                "Margarita" -> listOf("Con piña", "Sin piña", "Vegana")
                else -> emptyList()
            }

            Text("Opción:", fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(6.dp))

            Column {
                opcionesPizza.forEach { opcion ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 2.dp)
                            .clickable { opcionPizza = opcion }
                    ) {
                        RadioButton(
                            selected = opcionPizza == opcion,
                            onClick = { opcionPizza = opcion },
                            colors = RadioButtonDefaults.colors(selectedColor = rojoPrincipal)
                        )
                        Text(opcion, fontSize = 16.sp)
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // --- Tamaño de pizza ---
            Text("Tamaño:", fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(6.dp))

            val tamaños = listOf(
                "Pequeña" to precios.pizzaPequeña,
                "Mediana" to precios.pizzaMediana,
                "Grande" to precios.pizzaGrande
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                tamaños.forEach { (nombre, precio) ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .border(
                                width = 2.dp,
                                color = if (tamañoPizza == nombre) rojoPrincipal else Color.Gray,
                                shape = RoundedCornerShape(12.dp)
                            )
                            .clickable { tamañoPizza = nombre }
                            .padding(horizontal = 12.dp, vertical = 8.dp)
                    ) {
                        Text(
                            text = nombre,
                            fontWeight = if (tamañoPizza == nombre) FontWeight.Bold else FontWeight.Normal,
                            color = if (tamañoPizza == nombre) rojoPrincipal else Color.Black
                        )
                        Text(
                            text = "${precio} €",
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // --- Cantidad de pizzas ---
            Text("Cantidad de pizzas:", fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(6.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Button(
                    onClick = { if (cantidadPizza > 1) cantidadPizza-- },
                    colors = ButtonDefaults.buttonColors(containerColor = rojoPrincipal)
                ) { Text("-") }

                Text(
                    text = cantidadPizza.toString(),
                    modifier = Modifier.padding(horizontal = 20.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Button(
                    onClick = { cantidadPizza++ },
                    colors = ButtonDefaults.buttonColors(containerColor = rojoPrincipal)
                ) { Text("+") }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Divider(color = Color.LightGray, thickness = 1.dp)
            Spacer(modifier = Modifier.height(14.dp))

            // --- Bebidas ---
            Text("Bebida:", fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(6.dp))

            val bebidas = listOf(
                "Agua" to Color(0xFF4FC3F7),
                "Cola" to marronCola, // ahora marrón
                "Sin bebida" to Color(0xFFBDBDBD)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                bebidas.forEach { (nombre, color) ->
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(if (bebida == nombre) color else grisClaro)
                            .clickable {
                                bebida = nombre
                                if (nombre == "Sin bebida") cantidadBebida = 0
                                else if (cantidadBebida < 1) cantidadBebida = 1
                            }
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Text(
                            text = nombre,
                            color = if (bebida == nombre) Color.White else Color.Black,
                            fontWeight = if (bebida == nombre) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                }
            }

            // --- Solo muestra contador si hay bebida ---
            if (bebida != "Sin bebida") {
                Spacer(modifier = Modifier.height(10.dp))
                Text("Cantidad de bebidas:", fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(6.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Button(
                        onClick = { if (cantidadBebida > 1) cantidadBebida-- },
                        colors = ButtonDefaults.buttonColors(containerColor = rojoPrincipal)
                    ) { Text("-") }

                    Text(
                        text = cantidadBebida.toString(),
                        modifier = Modifier.padding(horizontal = 20.dp),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Button(
                        onClick = { cantidadBebida++ },
                        colors = ButtonDefaults.buttonColors(containerColor = rojoPrincipal)
                    ) { Text("+") }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Divider(color = Color.LightGray, thickness = 1.dp)
        }


        // PRECIO TOTAL

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(rojoPrincipal)
                .padding(vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "💰 Total: %.2f €".format(precioTotal),
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}


