package aziz.academy.presentation.screens.main.home

import androidx.compose.runtime.Immutable
import aziz.academy.domain.model.home.HomePageModel
import aziz.academy.domain.model.home.carousel.CarouselItem
import aziz.academy.domain.model.home.courses.Course
import aziz.academy.presentation.base.UiEvent

@Immutable
sealed class HomePageEvent : UiEvent {

    data object Default : HomePageEvent()

    data object FetchHomeData : HomePageEvent()

    data class HomeDataLoaded(val homeData: HomePageModel?) : HomePageEvent()

    data class ShowError(val error: String) : HomePageEvent()

}