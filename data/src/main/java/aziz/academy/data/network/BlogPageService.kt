package aziz.academy.data.network

import aziz.academy.data.dto.blog.BlogResponseDto
import retrofit2.Response
import retrofit2.http.GET

interface BlogPageService {
    @GET("api/blog/")
    suspend fun getBlogsList(): Response<BlogResponseDto>
}