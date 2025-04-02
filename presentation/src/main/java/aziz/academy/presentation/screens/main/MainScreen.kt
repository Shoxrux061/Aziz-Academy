package aziz.academy.presentation.screens.main

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import aziz.academy.presentation.ui.components.BottomNavHost
import aziz.academy.presentation.ui.components.MyBottomNavigation

@Preview(showBackground = true)
@Composable
fun MainScreen() {

    val navController = rememberNavController()

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
        )
    }
}