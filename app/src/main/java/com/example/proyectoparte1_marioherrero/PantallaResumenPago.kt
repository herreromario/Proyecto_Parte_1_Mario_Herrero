package com.example.proyectoparte1_marioherrero.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectoparte1_marioherrero.R
import com.example.proyectoparte1_marioherrero.datos.Data

@Composable
fun ResumenPago(
    modifier: Modifier = Modifier,
) {
    val pedidos = Data().cargarPedidos()
    val pedido = pedidos.first { it.id == 3 } // Pedido de ejemplo

    val rojoPrincipal = Color(0xFFE53935)
    val grisFondo = Color(0xFFF5F5F5)

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
                text = stringResource(R.string.titulo_resumen_pago),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = rojoPrincipal,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // --- Imagen ---
            Image(
                painter = painterResource(id = R.drawable.stiker_pagado__2_),
                contentDescription = stringResource(R.string.descripcion_pago_completado),
                modifier = Modifier
                    .size(180.dp)
                    .padding(bottom = 12.dp),
                contentScale = ContentScale.Fit
            )

            // --- Texto de confirmación ---
            Text(
                text = stringResource(R.string.texto_pedido_realizado),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(18.dp))

            // --- Tarjeta de resumen ---
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp)),
                colors = CardDefaults.cardColors(containerColor = grisFondo)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.Start
                ) {

                    Text(
                        text = stringResource(R.string.texto_pedido_numero, pedido.id),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = rojoPrincipal
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = stringResource(
                            R.string.texto_detalle_pizza,
                            pedido.pizzaCount,
                            pedido.pizzaType,
                            pedido.pizzaSize
                        ),
                        fontSize = 16.sp
                    )
                    Text(
                        text = stringResource(
                            R.string.texto_detalle_bebida,
                            pedido.drinkCount,
                            pedido.drink
                        ),
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Divider(color = Color.LightGray, thickness = 1.dp)
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = stringResource(R.string.texto_importe_pagado, pedido.totalPrice),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 17.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // --- Mensaje final ---
            Text(
                text = stringResource(R.string.texto_enhorabuena),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = stringResource(R.string.texto_pedido_procesado, pedido.id),
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        }

        // --- Botones inferiores ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            // --- Botón continuar ---
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(14.dp))
                    .background(rojoPrincipal)
                    .clickable { }
                    .padding(vertical = 14.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.boton_continuar),
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // --- Botón factura ---
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color.DarkGray)
                    .clickable { }
                    .padding(vertical = 14.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.boton_factura),
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
