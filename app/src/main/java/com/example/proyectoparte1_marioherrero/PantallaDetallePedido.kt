package com.example.proyectoparte1_marioherrero

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
            text = stringResource(R.string.titulo_detalle_pedido),
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
                text = stringResource(R.string.texto_pedido_numero, pedido.id),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            DetalleTexto(stringResource(R.string.etiqueta_fecha), pedido.date)
            DetalleTexto(stringResource(R.string.etiqueta_tipo_pizza), pedido.pizzaType)

            pedido.pizzaOptions?.let {
                DetalleTexto(stringResource(R.string.etiqueta_opcion_pizza), it)
            }

            DetalleTexto(stringResource(R.string.etiqueta_tamano_pizza), pedido.pizzaSize)
            DetalleTexto(stringResource(R.string.etiqueta_cantidad_pizza), pedido.pizzaCount.toString())
            DetalleTexto(stringResource(R.string.etiqueta_bebida), "${pedido.drink} (${pedido.drinkCount})")

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp),
                thickness = DividerDefaults.Thickness,
                color = DividerDefaults.color
            )

            Text(
                text = stringResource(R.string.texto_total_precio, pedido.totalPrice),
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
                text = stringResource(R.string.titulo_datos_usuario),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            DetalleTexto(stringResource(R.string.etiqueta_nombre), "${usuario.name} ${usuario.surname}")
            DetalleTexto(stringResource(R.string.etiqueta_correo), usuario.email)
            DetalleTexto(stringResource(R.string.etiqueta_telefono), usuario.phoneNumber)
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
