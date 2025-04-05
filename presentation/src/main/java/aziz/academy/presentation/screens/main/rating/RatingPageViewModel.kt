package aziz.academy.presentation.screens.main.rating

import androidx.lifecycle.viewModelScope
import aziz.academy.domain.useCase.RatingPageUseCase
import aziz.academy.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RatingPageViewModel @Inject constructor(private val useCase: RatingPageUseCase) :
    BaseViewModel<RatingPageState, RatingPageEvent>() {

    private val reducer = RatingPageReducer(
        initial = RatingPageState.initial()
    )

    override val state: StateFlow<RatingPageState>
        get() = reducer.state

    fun sendEvent(event: RatingPageEvent) {

        when (event) {
            is RatingPageEvent.FetchRatingData -> getRatingData()
            else -> reducer.sendEvent(event)
        }
    }

    private fun getRatingData() {
        reducer.sendEvent(RatingPageEvent.FetchRatingData())

        viewModelScope.launch {

            useCase.getRatings().collect { result ->
                result.data?.let {
                    sendEvent(RatingPageEvent.RatingDataLoaded(result.data))
                }
            }
        }
    }
}