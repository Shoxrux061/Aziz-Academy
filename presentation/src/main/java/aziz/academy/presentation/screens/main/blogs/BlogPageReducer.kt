package aziz.academy.presentation.screens.main.blogs

import android.util.Log
import aziz.academy.presentation.base.Reducer

class BlogPageReducer(
    initial: BlogPageState
) : Reducer<BlogPageState, BlogPageEvent>(initial) {

    override fun reduce(oldState: BlogPageState, event: BlogPageEvent) {

        val newState = when (event) {
            is BlogPageEvent.Default -> oldState.copy(isLoading = false, error = null)
            is BlogPageEvent.FetchBlogData -> oldState.copy(isLoading = true)
            is BlogPageEvent.BlogDataLoaded -> oldState.copy(
                isLoading = false,
                error = null,
                blogData = event.blogsData
            )

            is BlogPageEvent.ShowError -> oldState.copy(isLoading = false, error = event.error)
        }

        setState(newState)

    }
}