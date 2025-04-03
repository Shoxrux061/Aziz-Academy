package aziz.academy.data.repository

import android.util.Log
import aziz.academy.core.handler.NetworkResult
import aziz.academy.data.mapper.toDomain
import aziz.academy.data.network.BlogPageService
import aziz.academy.domain.model.home.blog.BlogDataItem
import aziz.academy.domain.repository.BlogRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BlogRepositoryImpl @Inject constructor(private val apiService: BlogPageService) :
    BlogRepository {

    override suspend fun getBlogList(): Flow<NetworkResult<List<BlogDataItem>>> = flow {
        emit(NetworkResult.Loading())

        try {

            val response = apiService.getBlogsList()
            if (response.isSuccessful) {
                response.body()?.let { dtoList ->
                    val blogs = dtoList.map { it.toDomain() }
                    Log.d("TAGRepository", "getBlogList: $blogs")
                    emit(NetworkResult.Success(blogs))
                }
            }

        } catch (e: Exception) {
            Log.d("TAGRepository", "getBlogList: ${e.localizedMessage}")

            emit(NetworkResult.Error(e.localizedMessage ?: "Something went wrong"))
        }

    }
}