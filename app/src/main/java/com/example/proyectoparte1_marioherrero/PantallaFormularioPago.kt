package com.example.proyectoparte1_marioherrero.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectoparte1_marioherrero.R

@Composable
fun FormularioPago(
    modifier: Modifier = Modifier,
    total: Double = 25.50 // Cantidad por defecto
) {

    var tipoTarjeta by remember { mutableStateOf("VISA") }
    var numeroTarjeta by remember { mutableStateOf("") }
    var fechaValidez by remember { mutableStateOf("") }
    var codigoSeguridad by remember { mutableStateOf("") }

    val rojoPrincipal = Color(0xFFE53935)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // FORMULARIO DE PAGO
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // --- Título ---
            Text(
                text = stringResource(R.string.titulo_formulario_pago),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = rojoPrincipal,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // --- Tipo de tarjeta ---
            Text(stringResource(R.string.texto_tipo_tarjeta), fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(6.dp))

            val tiposTarjeta = listOf(
                stringResource(R.string.tarjeta_visa),
                stringResource(R.string.tarjeta_mastercard),
                stringResource(R.string.tarjeta_euro6000)
            )

            Column(modifier = Modifier.fillMaxWidth()) {
                tiposTarjeta.forEach { tipo ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { tipoTarjeta = tipo }
                            .padding(vertical = 2.dp)
                    ) {
                        RadioButton(
                            selected = tipoTarjeta == tipo,
                            onClick = { tipoTarjeta = tipo },
                            colors = RadioButtonDefaults.colors(selectedColor = rojoPrincipal)
                        )
                        Text(text = tipo, fontSize = 16.sp)
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            Divider(thickness = 1.dp, color = Color.LightGray)
            Spacer(modifier = Modifier.height(14.dp))

            // --- Número de tarjeta ---
            Text(stringResource(R.string.texto_numero_tarjeta), fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(6.dp))

            OutlinedTextField(
                value = numeroTarjeta,
                onValueChange = { if (it.length <= 19) numeroTarjeta = it },
                placeholder = { Text(stringResource(R.string.placeholder_numero_tarjeta)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.height(16.dp))

            // --- Fila con Fecha y Código ---
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                // --- Fecha de validez ---
                Column(modifier = Modifier.weight(1f)) {
                    Text(stringResource(R.string.texto_fecha_validez), fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(6.dp))

                    OutlinedTextField(
                        value = fechaValidez,
                        onValueChange = {
                            var texto = it.filter { c -> c.isDigit() }
                            if (texto.length > 2 && !texto.contains("/")) {
                                texto = texto.substring(0, 2) + "/" + texto.substring(2)
                            }
                            if (texto.length <= 5) fechaValidez = texto
                        },
                        placeholder = { Text(stringResource(R.string.placeholder_fecha_validez)) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                // --- Código de seguridad ---
                Column(modifier = Modifier.weight(1f)) {
                    Text(stringResource(R.string.texto_codigo_seguridad), fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(6.dp))
                    OutlinedTextField(
                        value = codigoSeguridad,
                        onValueChange = { if (it.length <= 3) codigoSeguridad = it },
                        placeholder = { Text(stringResource(R.string.placeholder_codigo_seguridad)) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
        }

        // BOTÓN PROCEDER CON EL PAGO
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(rojoPrincipal)
                .clickable { }
                .padding(vertical = 14.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.boton_proceder_pago, total),
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}
