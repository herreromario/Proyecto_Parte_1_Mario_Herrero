package com.example.proyectoparte1_marioherrero.modelo

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Usuario(
    val id: Int,
    val name: String,
    val surname: String,
    val email: String,
    val phoneNumber: String,
    @DrawableRes val imageResourceID: Int
)
