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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectoparte1_marioherrero.R
import com.example.proyectoparte1_marioherrero.datos.Data

@Composable
fun RealizarPedido(modifier: Modifier = Modifier) {

    val data = Data()
    val precios = data.obtenerPrecios()

    var tipoPizza by remember { mutableStateOf("Barbacoa") }
    var opcionPizza by remember { mutableStateOf("") }
    var tamañoPizza by remember { mutableStateOf("Mediana") }
    var cantidadPizza by remember { mutableIntStateOf(1) }
    var bebida by remember { mutableStateOf("Agua") }
    var cantidadBebida by remember { mutableIntStateOf(1) }

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

    val rojoPrincipal = Color(0xFFE53935)
    val grisClaro = Color(0xFFF5F5F5)
    val marronCola = Color(0xFF795548)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
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
                text = stringResource(R.string.titulo_realizar_pedido),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = rojoPrincipal,
                modifier = Modifier.padding(bottom = 10.dp)
            )

            // --- Tipo de pizza ---
            Text(stringResource(R.string.texto_selecciona_pizza), fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(8.dp))

            val tiposPizza = listOf(
                stringResource(R.string.pizza_barbacoa) to Color(0xFFFF7043),
                stringResource(R.string.pizza_romana) to Color(0xFF66BB6A),
                stringResource(R.string.pizza_margarita) to Color(0xFF42A5F5)
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
                stringResource(R.string.pizza_barbacoa) -> listOf(
                    stringResource(R.string.opcion_cerdo),
                    stringResource(R.string.opcion_pollo),
                    stringResource(R.string.opcion_ternera)
                )
                stringResource(R.string.pizza_romana) -> listOf(
                    stringResource(R.string.opcion_con_champinones),
                    stringResource(R.string.opcion_sin_champinones)
                )
                stringResource(R.string.pizza_margarita) -> listOf(
                    stringResource(R.string.opcion_con_pina),
                    stringResource(R.string.opcion_sin_pina),
                    stringResource(R.string.opcion_vegana)
                )
                else -> emptyList()
            }

            Text(stringResource(R.string.etiqueta_opcion_pizza), fontWeight = FontWeight.SemiBold)
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
            Text(stringResource(R.string.etiqueta_tamano_pizza), fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(6.dp))

            val tamaños = listOf(
                stringResource(R.string.tamano_pequena) to precios.pizzaPequeña,
                stringResource(R.string.tamano_mediana) to precios.pizzaMediana,
                stringResource(R.string.tamano_grande) to precios.pizzaGrande
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
                            text = stringResource(R.string.texto_precio_pizza, precio),
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // --- Cantidad de pizzas ---
            Text(stringResource(R.string.etiqueta_cantidad_pizza_plural), fontWeight = FontWeight.SemiBold)
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
            Text(stringResource(R.string.etiqueta_bebida), fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(6.dp))

            val bebidas = listOf(
                stringResource(R.string.bebida_agua) to Color(0xFF4FC3F7),
                stringResource(R.string.bebida_cola) to marronCola,
                stringResource(R.string.bebida_sin) to Color(0xFFBDBDBD)
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

            if (bebida != stringResource(R.string.bebida_sin)) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(stringResource(R.string.etiqueta_cantidad_bebida), fontWeight = FontWeight.SemiBold)
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
                text = stringResource(R.string.texto_total_precio, precioTotal),
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}
