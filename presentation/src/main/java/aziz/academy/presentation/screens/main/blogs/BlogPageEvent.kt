package aziz.academy.presentation.screens.main.blogs

import androidx.compose.runtime.Immutable
import aziz.academy.domain.model.home.blog.BlogDataItem
import aziz.academy.presentation.base.UiEvent

@Immutable
sealed class BlogPageEvent : UiEvent {

    data object Default : BlogPageEvent()

    data object FetchBlogData : BlogPageEvent()

    data class BlogDataLoaded(val blogsData: List<BlogDataItem>?) : BlogPageEvent()

    data class ShowError(val error: String) : BlogPageEvent()

}