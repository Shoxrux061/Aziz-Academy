package aziz.academy.presentation.screens.main.home

import android.util.Log
import aziz.academy.presentation.base.Reducer

class HomePageReducer(
    initial: HomePageState
) : Reducer<HomePageState, HomePageEvent>(initial) {

    override fun reduce(oldState: HomePageState, event: HomePageEvent) {

        Log.d("ReducerTAG", "reduce: $event")

        val newState = when (event) {
            is HomePageEvent.Default -> oldState.copy(error = null, isLoading = false)
            is HomePageEvent.ShowError -> oldState.copy(error = event.error, isLoading = false)
            is HomePageEvent.FetchHomeData -> oldState.copy(isLoading = true, error = null)
            is HomePageEvent.HomeDataLoaded -> oldState.copy(
                isLoading = false,
                error = null,
                homeData = event.homeData
            )
        }
        setState(newState)

    }
}