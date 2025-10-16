package com.example.proyectoparte1_marioherrero.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectoparte1_marioherrero.datos.Data
import com.example.proyectoparte1_marioherrero.modelo.Pedido

@Composable
fun DetallePedido(modifier: Modifier = Modifier) {
    val pedidos = Data().cargarPedidos()
    val pedido = pedidos.first { it.id == 3 } // Selecciono el pedido con el ID 3

    TarjetaDetallePedido(modifier, pedido = pedido)
}

@Composable
fun TarjetaDetallePedido(modifier: Modifier, pedido: Pedido) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "Detalles del pedido #${pedido.id}",
            style = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            textAlign = TextAlign.Center // Centrar el título (modifier + textAlign)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Detalles alineados a la izquierda
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = "Fecha: ${pedido.date}", fontSize = 18.sp)
            Text(text = "Tipo de pizza: ${pedido.pizzaType}")
            Text(text = "Tamaño: ${pedido.pizzaSize}")
            Text(text = "Cantidad: ${pedido.pizzaCount}")
            Text(text = "Bebida: ${pedido.drink} (${pedido.drinkCount})")
            Text(text = "Total: ${pedido.totalPrice} €", fontWeight = FontWeight.Bold)
        }
    }
}