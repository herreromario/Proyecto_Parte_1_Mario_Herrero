package com.example.proyectoparte1_marioherrero.modelo

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Usuario(
    @StringRes val stringResourceNameID: Int,
    @StringRes val stringResourceSurnameID: Int,
    @StringRes val stringResourceEmailID: Int,
    @StringRes val stringResourcePhoneID: Int,
    @StringRes val stringResourceIdentityID: Int,
    @DrawableRes val imageResourceID: Int
)
