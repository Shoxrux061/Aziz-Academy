package aziz.academy.presentation.screens.main

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import aziz.academy.presentation.screens.main.home.HomePageEvent
import aziz.academy.presentation.screens.main.home.HomePageViewModel
import aziz.academy.presentation.ui.components.BottomNavHost
import aziz.academy.presentation.ui.components.MyBottomNavigation

@Preview(showBackground = true)
@Composable
fun MainScreen() {

    val navController = rememberNavController()

    val homePageViewModel = hiltViewModel<HomePageViewModel>()

    LaunchedEffect(Unit) {
        homePageViewModel.sendEvent(HomePageEvent.FetchHomeData)
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
            homePageViewModel = homePageViewModel
        )
    }
}