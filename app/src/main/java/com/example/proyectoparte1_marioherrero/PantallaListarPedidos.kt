package com.example.proyectoparte1_marioherrero

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectoparte1_marioherrero.datos.Data
import com.example.proyectoparte1_marioherrero.modelo.Pedido

@Composable
fun ListarPedidos(modifier: Modifier = Modifier) {
    val pedidos = Data().cargarPedidos()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Lista de pedidos",
            style = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp), // Separación vertical entre pedidos
            modifier = Modifier.fillMaxWidth()
        ) {
            items(pedidos) { pedido ->
                TarjetaPedido(pedido = pedido)
            }
        }
    }
}

@Composable
fun TarjetaPedido(pedido: Pedido, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp), // Separación horizontal de las tarjetas
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp), // Sombreado de la tarjeta
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFDFDFD))
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(6.dp) // Separación entre los textos
        ) {
            Text(
                text = "Pedido #${pedido.id}",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                ),
                color = Color(0xFFB71C1C)
            )

            Text(text = "🍕 ${pedido.pizzaCount}x ${pedido.pizzaType} (${pedido.pizzaSize})")
            Text(text = "🥤 ${pedido.drinkCount}x ${pedido.drink}")
            Text(
                text = "💰 Total: ${pedido.totalPrice} €",
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "📅 Fecha: ${pedido.date}",
                color = Color.Gray,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { /* TODO: Acción del botón */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE53935)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "Ver detalles", fontSize = 16.sp)
            }
        }
    }
}
