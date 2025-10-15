package com.example.proyectoparte1_marioherrero.datos

import com.example.proyectoparte1_marioherrero.R
import com.example.proyectoparte1_marioherrero.modelo.Usuario

class Data {
    fun cargarUsuarios(): List<Usuario> = listOf(
        Usuario(
            R.string.name1,
            R.string.surname1,
            R.string.email1,
            R.string.phone1,
            stringResourceIdentityID = R.string.identity1,
            R.drawable.profilepicture1
        )
    )
}