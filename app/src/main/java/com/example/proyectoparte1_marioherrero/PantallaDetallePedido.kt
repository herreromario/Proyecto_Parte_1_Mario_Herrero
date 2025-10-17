package com.example.proyectoparte1_marioherrero

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
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
import com.example.proyectoparte1_marioherrero.modelo.Usuario

@Composable
fun DetallePedido(modifier: Modifier = Modifier) {
    val pedidos = Data().cargarPedidos()
    val pedido = pedidos.first { it.id == 3 } // Pedido de ejemplo
    val usuario = Data().cargarUsuario()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Detalle del pedido",
            style = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        TarjetaDatosUsuario(usuario = usuario)
        Spacer(modifier = Modifier.height(16.dp))
        TarjetaDetallePedido(pedido = pedido)
    }
}

@Composable
fun TarjetaDetallePedido(modifier: Modifier = Modifier, pedido: Pedido) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(
                text = "Pedido #${pedido.id}",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            DetalleTexto("Fecha", pedido.date)
            DetalleTexto("Tipo de pizza", pedido.pizzaType)

            // Mostrar opción personalizada (si la hay)

            pedido.pizzaOptions?.let {
                DetalleTexto("Opción", it)
            }

            DetalleTexto("Tamaño", pedido.pizzaSize)
            DetalleTexto("Cantidad", pedido.pizzaCount.toString())
            DetalleTexto("Bebida", "${pedido.drink} (${pedido.drinkCount})")

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp),
                thickness = DividerDefaults.Thickness,
                color = DividerDefaults.color
            )

            Text(
                text = "Total: ${pedido.totalPrice}",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}

@Composable
fun TarjetaDatosUsuario(modifier: Modifier = Modifier, usuario: Usuario) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(
                text = "Datos del usuario",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            DetalleTexto("Nombre", "${usuario.name} ${usuario.surname}")
            DetalleTexto("Correo", usuario.email)
            DetalleTexto("Teléfono", usuario.phoneNumber)
        }
    }
}

@Composable
fun DetalleTexto(etiqueta: String, valor: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "$etiqueta:",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
        Text(
            text = valor,
            fontSize = 16.sp,
            textAlign = TextAlign.End
        )
    }
}
