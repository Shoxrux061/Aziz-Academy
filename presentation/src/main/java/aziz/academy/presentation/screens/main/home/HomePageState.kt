package aziz.academy.presentation.screens.main.home

import aziz.academy.domain.model.home.HomePageModel
import aziz.academy.domain.model.home.carousel.CarouselItem
import aziz.academy.domain.model.home.courses.Course
import aziz.academy.presentation.base.UiState

data class HomePageState(
    val isLoading: Boolean,
    val homeData: HomePageModel? = null,
    val error: String? = null

) : UiState {

    companion object {

        fun initial() = HomePageState(
            isLoading = false,
            homeData = null,
            error = null,
        )
    }
}
