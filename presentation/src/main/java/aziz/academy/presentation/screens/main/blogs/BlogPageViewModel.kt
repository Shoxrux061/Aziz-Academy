package aziz.academy.presentation.screens.main.blogs

import androidx.lifecycle.viewModelScope
import aziz.academy.domain.useCase.BlogPageUseCase
import aziz.academy.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BlogPageViewModel @Inject constructor(private val useCase: BlogPageUseCase) :
    BaseViewModel<BlogPageState, BlogPageEvent>() {

    private val reducer = BlogPageReducer(
        initial = BlogPageState.initial()
    )


    override val state: StateFlow<BlogPageState>
        get() = reducer.state

    fun sendEvent(event: BlogPageEvent) {

        when (event) {
            is BlogPageEvent.FetchBlogData -> getBlogData()
            else -> reducer.sendEvent(event)
        }

    }

    private fun getBlogData() {

        reducer.sendEvent(BlogPageEvent.FetchBlogData)

        viewModelScope.launch {
            try {
                useCase.getBlogs().collect { result ->
                    reducer.sendEvent(BlogPageEvent.BlogDataLoaded(result.data))
                }

            } catch (e: Exception) {
                reducer.sendEvent(BlogPageEvent.ShowError(e.localizedMessage ?: "ViewModel Error"))
            }
        }
    }
}