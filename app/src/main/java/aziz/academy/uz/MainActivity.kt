package aziz.academy.uz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import aziz.academy.presentation.screens.main.MainScreen
import aziz.academy.presentation.screens.main.home.CoursesPage
import aziz.academy.uz.ui.theme.AzizAcademyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AzizAcademyTheme {
                MainScreen()
            }
        }
    }
}
