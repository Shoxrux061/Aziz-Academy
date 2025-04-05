package aziz.academy.presentation.screens.main.rating

import aziz.academy.domain.model.home.rating.RatingResult
import aziz.academy.presentation.base.UiState

data class RatingPageState(
    val isLoading: Boolean,
    val ratingData: List<RatingResult>? = null,
    val error: String?

) : UiState {

    companion object {

        fun initial() = RatingPageState(
            isLoading = false,
            ratingData = null,
            error = null
        )
    }
}