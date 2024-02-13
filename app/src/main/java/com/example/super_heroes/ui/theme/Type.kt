package com.example.super_heroes.ui.theme
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.super_heroes.R

val Cabin = FontFamily(
    Font(R.font.cabin_regular, FontWeight.Normal),
    Font(R.font.cabin_bold, FontWeight.Bold)
)
val Protest= FontFamily(
    Font(R.font.protest_revolution_regular,FontWeight.Normal),
    Font(R.font.protest_revolution_regular,FontWeight.Bold)
)
val Honk= FontFamily(
    Font(R.font.honk_regular_variablefont_morf_shln,FontWeight.Normal),
    Font(R.font.honk_regular_variablefont_morf_shln,FontWeight.Bold)
)
val Permanent= FontFamily(
    Font(R.font.permanentmarker_regular,FontWeight.Normal),
    Font(R.font.permanentmarker_regular,FontWeight.Bold)
)
val Cinzel= FontFamily(
    Font(R.font.cinzel_variablefont_wght,FontWeight.Normal),
    Font(R.font.cinzel_variablefont_wght,FontWeight.Bold)
)
val Unbounded= FontFamily(
    Font(R.font.unbounded_variablefont_wght,FontWeight.Normal),
    Font(R.font.unbounded_variablefont_wght,FontWeight.Bold)
)
// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Permanent,
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Unbounded,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.5.sp
    ),

    displayLarge = TextStyle(
        fontFamily = Permanent,
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Permanent,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    displaySmall = TextStyle(
        fontFamily = Permanent,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp
    )
)
