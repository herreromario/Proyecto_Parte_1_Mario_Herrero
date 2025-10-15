package com.example.proyectoparte1_marioherrero

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectoparte1_marioherrero.datos.Data
import com.example.proyectoparte1_marioherrero.modelo.Usuario
import com.example.proyectoparte1_marioherrero.ui.theme.ProyectoParte1MarioHerreroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoParte1MarioHerreroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaUsuario(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PantallaUsuario(modifier: Modifier = Modifier) {
    // Como tu Data devuelve una lista, tomamos el primer usuario
    val usuario = Data().cargarUsuarios().first()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TarjetaUsuario(usuario = usuario)

        Spacer(modifier = Modifier.height(40.dp))

        PreguntarOpciones()
    }
}


@Composable
fun TarjetaUsuario(usuario: Usuario, modifier: Modifier = Modifier) {
    Card(modifier = Modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(usuario.imageResourceID),
                contentDescription = stringResource(usuario.stringResourceIdentityID),
                modifier = Modifier
                    .size(180.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(usuario.stringResourceNameID),
                style = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold)
            )
            Text(text = stringResource(usuario.stringResourceSurnameID))
            Text(text = stringResource(usuario.stringResourceEmailID))
            Text(text = stringResource(usuario.stringResourcePhoneID))
        }
    }
}

@Composable
fun PreguntarOpciones(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "¿Qué deseas hacer?",
            modifier = Modifier.padding(bottom = 20.dp),
            style = TextStyle(
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        )
        BotonesOpciones()
    }
}

@Composable
fun BotonesOpciones() {
    Button(
        onClick = { /* TODO: Acción del primer botón */ },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(20.dp)
            .size(width = 250.dp, height = 70.dp)
    ) {
        Text(text = "Realizar un pedido", fontSize = 20.sp)
    }

    Button(
        onClick = { /* TODO: Acción del segundo botón */ },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(20.dp)
            .size(width = 250.dp, height = 70.dp)
    ) {
        Text(text = "Listar pedidos", fontSize = 20.sp)
    }
}



