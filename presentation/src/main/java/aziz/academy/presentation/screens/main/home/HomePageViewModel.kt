package aziz.academy.presentation.screens.main.home

import androidx.lifecycle.viewModelScope
import aziz.academy.domain.useCase.HomePageUseCase
import aziz.academy.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(private val useCase: HomePageUseCase) :
    BaseViewModel<HomePageState, HomePageEvent>() {

    private val reducer = HomePageReducer(
        initial = HomePageState.initial()
    )

    override val state: StateFlow<HomePageState>
        get() = reducer.state

    fun sendEvent(event: HomePageEvent) {

        when (event) {
            is HomePageEvent.FetchHomeData -> getHomeData()
            else -> reducer.sendEvent(event)
        }

    }

    private fun getHomeData() {

        reducer.sendEvent(HomePageEvent.FetchHomeData)

        viewModelScope.launch(Dispatchers.IO) {
            try {
                useCase.getHomeData().collect { result ->
                    sendEvent(HomePageEvent.HomeDataLoaded(result.data))
                }
            } catch (e: Exception) {
                reducer.sendEvent(
                    HomePageEvent.ShowError(
                        e.localizedMessage ?: "Something went wrong"
                    )
                )
            }
        }
    }
}