package aziz.academy.uz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import aziz.academy.presentation.screens.course_details.CourseDataViewModel
import aziz.academy.presentation.screens.main.MainScreen
import aziz.academy.uz.ui.theme.AzizAcademyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val courseDetailsViewModel: CourseDataViewModel by viewModels()

        setContent {
            AzizAcademyTheme {
                MainScreen(courseDetailsViewModel)
            }
        }
    }
}
