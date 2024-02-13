package com.example.super_heroes

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.super_heroes.model.Imagenes


@Composable
fun ImagenesList(
    imagenes: List<Imagenes>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    val visibleState = remember { MutableTransitionState(false).apply { targetState = true } }

    AnimatedVisibility(
        visibleState = visibleState,
        enter = fadeIn(
            animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy)
        ),
        exit = fadeOut(),
        modifier = modifier
    ) {
        LazyColumn(contentPadding = contentPadding) {
            itemsIndexed(imagenes) { index, imagen ->
                val day = (index + 1).toString() // day como contador

                val shortDescription = when (index + 1) {
                    1 -> stringResource(R.string.short_description1)
                    2 -> stringResource(R.string.short_description2)
                    3 -> stringResource(R.string.short_description3)
                    4 -> stringResource(R.string.short_description4)
                    5 -> stringResource(R.string.short_description5)
                    6 -> stringResource(R.string.short_description6)
                    7 -> stringResource(R.string.short_description7)
                    8 -> stringResource(R.string.short_description8)
                    9 -> stringResource(R.string.short_description9)
                    10 -> stringResource(R.string.short_description10)
                    else -> ""
                }

                val longDescription = when (index + 1) {
                    1 -> stringResource(R.string.long_description1)
                    2 -> stringResource(R.string.long_description2)
                    3 -> stringResource(R.string.long_description3)
                    4 -> stringResource(R.string.long_description4)
                    5 -> stringResource(R.string.long_description5)
                    6 -> stringResource(R.string.long_description6)
                    7 -> stringResource(R.string.long_description7)
                    8 -> stringResource(R.string.long_description8)
                    9 -> stringResource(R.string.long_description9)
                    10 -> stringResource(R.string.long_description10)
                    else -> ""
                }

                ImagenesListImtems(
                    imagenes = imagen,
                    day = day,
                    shortDescription = shortDescription,
                    longDescription = longDescription,
                    modifier = Modifier
                        .padding(horizontal = dimensionResource(R.dimen.padding_medium), vertical = dimensionResource(R.dimen.padding_small))
                )
            }
        }

    }
}
@Composable
fun ImagenesListImtems(
    imagenes: Imagenes,
    modifier: Modifier = Modifier,
    day: String,
    shortDescription: String,
    longDescription: String
) {
    var isExpanded by remember { mutableStateOf(false) }

    val backgroundColor by animateColorAsState(
        targetValue = if (isExpanded) Color.Transparent else Color.Transparent,
        label = ""
    )

    val scale by animateFloatAsState(
        targetValue = if (isExpanded) 1.2f else 1f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioHighBouncy), label = ""
    )

    val iconModifier = Modifier
        .size(dimensionResource(R.dimen.size50)) // Ajusta el tamaño del icono desplegable
        .padding(dimensionResource(R.dimen.padding_small))
        .clickable { isExpanded = !isExpanded }
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier.background(backgroundColor)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Día y primera frase en la misma línea
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium))
            ) {
                Text(
                    text = day,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(end = dimensionResource(R.dimen.padding_small))
                )

                Text(
                    text = shortDescription,
                    style = MaterialTheme.typography.displaySmall,
                    modifier = Modifier.weight(1f) // Ocupa todo el espacio restante
                )
            }

            // Icono para indicar desplegable
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null,
                tint = Color.White,
                modifier = iconModifier
            )

            // Imagen
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(R.dimen.size200))
                    .clip(RoundedCornerShape(dimensionResource(R.dimen.padding_small)))
                    .clickable { isExpanded = !isExpanded } // Toggle isExpanded state
                    .graphicsLayer(scaleX = scale, scaleY = scale)
            ) {
                Image(
                    painter = painterResource(imagenes.imageRes),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            if (isExpanded) {
                Text(
                    text = longDescription,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
                )
            }
        }
    }
}

