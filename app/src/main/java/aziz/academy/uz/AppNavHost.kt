package aziz.academy.uz

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import aziz.academy.core.utils.NavRoutes
import aziz.academy.presentation.screens.course_details.CourseDataViewModel
import aziz.academy.presentation.screens.course_details.CourseDetailsModel
import aziz.academy.presentation.screens.course_details.CourseDetailsScreen
import aziz.academy.presentation.screens.main.MainScreen

@Composable
fun AppNavHost(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = NavRoutes.MAIN_SCREEN,
        enterTransition = { fadeIn(animationSpec = tween(250)) },
        exitTransition = { fadeOut(animationSpec = tween(250)) }
    ) {

        composable(route = NavRoutes.MAIN_SCREEN) {
            MainScreen()
        }

        composable(
            route = "${NavRoutes.DETAILS_SCREEN}/{course}",
            arguments = listOf(navArgument("course") {
                type = NavType.ParcelableType(CourseDetailsModel::class.java)
            })
        ) {
            val viewModel: CourseDataViewModel = hiltViewModel()
            val screenModel = viewModel.screenModel
            CourseDetailsScreen(navController, screenModel)
        }
    }
}