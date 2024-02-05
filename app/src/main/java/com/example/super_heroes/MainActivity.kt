package com.example.super_heroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.super_heroes.model.Imagenes
import com.example.super_heroes.model.ImagenesRepository
import com.example.super_heroes.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiasApp()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun DiasApp() {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar()
            }
        ) {
            val heroes = ImagenesRepository.heroes
            ImagenesList(heroes = heroes, contentPadding = it)
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TopAppBar() {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displaySmall,
                )
            },
            navigationIcon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null,
                    modifier = Modifier
                        .clickable { /* Handle navigation icon click */ }
                        .padding(8.dp)
                )
            },
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
        )
    }

    @Composable
    fun ImagenesList(
        heroes: List<Imagenes>,
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
                itemsIndexed(heroes) { index, hero ->
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
                        hero = hero,
                        day = day,
                        shortDescription = shortDescription,
                        longDescription = longDescription,
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
            }

        }
    }


    @Composable
    fun ImagenesListImtems(
        hero: Imagenes,
        modifier: Modifier = Modifier,
        day: String,
        shortDescription: String,
        longDescription: String
    ) {
        val backgroundColor by animateColorAsState(
            targetValue = Color.Green,
            label = ""
        )

        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = modifier.background(backgroundColor)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                // Día
                Text(
                    text = day,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(16.dp)
                )

                Text(
                    text = shortDescription,
                    style = MaterialTheme.typography.displaySmall,
                    modifier = Modifier.padding(16.dp)
                )

                // Imagen
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(8.dp))
                ) {
                    Image(
                        painter = painterResource(hero.imageRes),
                        contentDescription = null,
                        alignment = Alignment.TopCenter,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text(
                    text = longDescription,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DiasApp10() {
        AppTheme {
            DiasApp()
        }
    }
}
