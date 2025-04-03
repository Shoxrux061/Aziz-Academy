package aziz.academy.presentation.screens.main.blogs

import aziz.academy.domain.model.home.HomePageModel
import aziz.academy.domain.model.home.blog.BlogDataItem
import aziz.academy.presentation.base.UiState

data class BlogPageState(
    val isLoading: Boolean,
    val blogData: List<BlogDataItem>? = null,
    val error: String? = null

) : UiState {

    companion object {

        fun initial() = BlogPageState(
            isLoading = false,
            blogData = null,
            error = null,
        )
    }
}
