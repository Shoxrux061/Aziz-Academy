package aziz.academy.uz.ui.theme

import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import aziz.academy.presentation.ui.color.BackgroundColor
import aziz.academy.presentation.ui.color.BlueLight
import aziz.academy.presentation.ui.color.ThemePrimary
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import aziz.academy.presentation.ui.color.ThemeSecondary

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = ThemePrimary,
    secondary = ThemeSecondary,
    tertiary = BlueLight

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun AzizAcademyTheme(
    /*darkTheme: Boolean = isSystemInDarkTheme(),*/
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {

    val systemUiController = rememberSystemUiController()


    SideEffect {
        systemUiController.setStatusBarColor(
            color = BackgroundColor,
            darkIcons = true
        )
        systemUiController.setNavigationBarColor(
            color = BackgroundColor,
            darkIcons = true
        )
    }


    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            /*if (darkTheme) dynamicDarkColorScheme(context) else */dynamicLightColorScheme(context)
        }

        /*darkTheme -> DarkColorScheme*/
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}