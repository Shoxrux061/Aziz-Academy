package aziz.academy.presentation.screens.main

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import aziz.academy.presentation.screens.course_details.CourseDataViewModel
import aziz.academy.presentation.screens.main.blogs.BlogPageEvent
import aziz.academy.presentation.screens.main.blogs.BlogPageViewModel
import aziz.academy.presentation.screens.main.home.HomePageEvent
import aziz.academy.presentation.screens.main.home.HomePageViewModel
import aziz.academy.presentation.screens.main.rating.RatingPageEvent
import aziz.academy.presentation.screens.main.rating.RatingPageViewModel
import aziz.academy.presentation.ui.components.BottomNavHost
import aziz.academy.presentation.ui.components.MyBottomNavigation

@Composable
fun MainScreen(
    courseDataViewModel: CourseDataViewModel
) {

    val navController = rememberNavController()

    val homePageViewModel = hiltViewModel<HomePageViewModel>()

    val blogViewModel = hiltViewModel<BlogPageViewModel>()

    val ratingViewModel = hiltViewModel<RatingPageViewModel>()

    LaunchedEffect(Unit) {
        homePageViewModel.sendEvent(HomePageEvent.FetchHomeData)
        blogViewModel.sendEvent(BlogPageEvent.FetchBlogData)
        ratingViewModel.sendEvent(RatingPageEvent.FetchRatingData())
    }

    Scaffold(
        bottomBar = {
            MyBottomNavigation(
                navController = navController
            )
        }
    ) { paddingValues ->

        BottomNavHost(
            paddingValues = paddingValues,
            navController = navController,
            homePageViewModel = homePageViewModel,
            blogPageViewModel = blogViewModel,
            courseDataViewModel = courseDataViewModel,
            ratingPageViewModel = ratingViewModel
        )
    }
}