package aziz.academy.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import aziz.academy.presentation.R
import aziz.academy.presentation.ui.color.BackgroundColor
import aziz.academy.presentation.ui.color.Gray
import aziz.academy.presentation.ui.color.GraySemiTransparent
import aziz.academy.presentation.ui.color.ThemePrimary
import aziz.academy.presentation.ui.color.ThemeSecondary

@Composable
fun MyBottomNavigation(
    navController: NavController
) {

    val listItem = listOf(
        BottomNavigationItem.HomePage,
        BottomNavigationItem.BlogPage,
        BottomNavigationItem.RatingPage,
        BottomNavigationItem.ProfilePage
    )
    Column {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.5.dp)
                .background(GraySemiTransparent)
        )

        NavigationBar(
            containerColor = BackgroundColor,
            modifier = Modifier.background(BackgroundColor)
        ) {
            val backStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = backStackEntry?.destination?.route
            listItem.forEach { item ->
                NavigationBarItem(
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(item.iconId),
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular))
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = ThemePrimary,
                        selectedTextColor = ThemePrimary,
                        unselectedIconColor = Gray,
                        unselectedTextColor = Gray
                    )
                )
            }
        }
    }
}