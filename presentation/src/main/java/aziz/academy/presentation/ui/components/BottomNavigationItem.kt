package aziz.academy.presentation.ui.components

import aziz.academy.core.utils.NavRoutes
import aziz.academy.presentation.R

sealed class BottomNavigationItem(val title: String, val iconId: Int, val route: String) {

    data object HomePage : BottomNavigationItem(
        title = "Asosiy",
        iconId = R.drawable.ic_home,
        route = NavRoutes.ITEM_HOME_PAGE
    )

    data object RatingPage : BottomNavigationItem(
        title = "Reytinglar",
        iconId = R.drawable.ic_cup,
        route = NavRoutes.ITEM_RATING_PAGE
    )

    data object BlogPage : BottomNavigationItem(
        title = "Blog",
        iconId = R.drawable.ic_blog,
        route = NavRoutes.ITEM_BLOG_PAGE
    )

    data object ProfilePage : BottomNavigationItem(
        title = "Profile",
        iconId = R.drawable.ic_profile,
        route = NavRoutes.ITEM_PROFILE_PAGE
    )

}