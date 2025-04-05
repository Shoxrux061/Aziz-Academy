package aziz.academy.presentation.screens.main.rating

import aziz.academy.presentation.base.Reducer

class RatingPageReducer(
    initial: RatingPageState
) : Reducer<RatingPageState, RatingPageEvent>(initial) {


    override fun reduce(oldState: RatingPageState, event: RatingPageEvent) {

        val newState = when (event) {

            is RatingPageEvent.Default -> oldState.copy(isLoading = false, error = null)
            is RatingPageEvent.FetchRatingData -> oldState.copy(isLoading = true, error = null)
            is RatingPageEvent.RatingDataLoaded -> oldState.copy(
                isLoading = false,
                error = null,
                ratingData = event.ratingData
            )

            is RatingPageEvent.ShowError -> oldState.copy(isLoading = false, error = event.error)

        }
        setState(newState)
    }
}