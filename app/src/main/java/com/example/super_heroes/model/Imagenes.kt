package com.example.super_heroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Imagenes(
    val id: Int,
    @StringRes val nameRes: Int,
    @StringRes val shortDescriptionRes: Int,
    @StringRes val longDescriptionRes: Int,
    @DrawableRes val imageRes: Int

)
