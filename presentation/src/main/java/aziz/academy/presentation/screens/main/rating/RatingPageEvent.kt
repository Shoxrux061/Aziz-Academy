package aziz.academy.presentation.screens.main.rating

import androidx.compose.runtime.Immutable
import aziz.academy.domain.model.home.rating.RatingResult
import aziz.academy.presentation.base.UiEvent

@Immutable
sealed class RatingPageEvent : UiEvent {

    data object Default : RatingPageEvent()

    data class FetchRatingData(val page: Int? = null) : RatingPageEvent()

    data class RatingDataLoaded(val ratingData: List<RatingResult>?) : RatingPageEvent()

    data class ShowError(val error: String?) : RatingPageEvent()

}