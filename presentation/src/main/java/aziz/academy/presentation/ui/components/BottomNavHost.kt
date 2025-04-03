package aziz.academy.presentation.ui.components

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import aziz.academy.core.utils.NavRoutes
import aziz.academy.presentation.screens.main.blogs.BlogPageViewModel
import aziz.academy.presentation.screens.main.blogs.BlogsPage
import aziz.academy.presentation.screens.main.home.CoursesPage
import aziz.academy.presentation.screens.main.home.HomePageViewModel

@Composable
fun BottomNavHost(
    navController: NavHostController,
    paddingValues: PaddingValues,
    homePageViewModel: HomePageViewModel,
    blogPageViewModel: BlogPageViewModel
) {

    NavHost(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        navController = navController,
        startDestination = NavRoutes.ITEM_HOME_PAGE,
        enterTransition = {
            fadeIn(animationSpec = tween(durationMillis = 250))
        },
        exitTransition = {
            fadeOut(animationSpec = tween(durationMillis = 250))
        },
        popEnterTransition = {
            fadeIn(animationSpec = tween(durationMillis = 250))
        },
        popExitTransition = {
            fadeOut(animationSpec = tween(durationMillis = 250))
        }
    ) {
        composable(route = NavRoutes.ITEM_HOME_PAGE) {
            CoursesPage(homePageViewModel, navController)
        }
        composable(route = NavRoutes.ITEM_RATING_PAGE) {
            Text("Rating")
        }
        composable(route = NavRoutes.ITEM_BLOG_PAGE) {
            BlogsPage(navController, blogPageViewModel)
        }
        composable(route = NavRoutes.ITEM_PROFILE_PAGE) {
            Text("Profile")
        }
    }
}