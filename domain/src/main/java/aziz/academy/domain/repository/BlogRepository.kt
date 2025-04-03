package aziz.academy.domain.repository

import aziz.academy.core.handler.NetworkResult
import aziz.academy.domain.model.home.blog.BlogDataItem
import kotlinx.coroutines.flow.Flow

interface BlogRepository {

    suspend fun getBlogList(): Flow<NetworkResult<List<BlogDataItem>>>

}