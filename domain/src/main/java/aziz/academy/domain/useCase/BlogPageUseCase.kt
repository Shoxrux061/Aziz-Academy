package aziz.academy.domain.useCase

import aziz.academy.domain.repository.BlogRepository
import javax.inject.Inject

class BlogPageUseCase @Inject constructor(private val repository: BlogRepository) {
    suspend fun getBlogs() = repository.getBlogList()
}