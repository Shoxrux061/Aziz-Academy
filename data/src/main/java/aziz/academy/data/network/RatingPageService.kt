package aziz.academy.data.network

import aziz.academy.data.dto.rating.RatingDto
import retrofit2.Response
import retrofit2.http.GET

interface RatingPageService {

    @GET("api/students/ratings/")
    suspend fun getRatings() : Response<RatingDto>

}