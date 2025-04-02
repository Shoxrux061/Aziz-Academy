package aziz.academy.data.network

import aziz.academy.data.dto.carousel.CarouselResponse
import aziz.academy.data.dto.courses.CoursesResponse
import retrofit2.Response
import retrofit2.http.GET

interface HomePageService {

    @GET("api/courses/?format=json")
    suspend fun getCourses(): Response<CoursesResponse>

    @GET("api/carousel-images/?format=json")
    suspend fun getCarousel(): Response<CarouselResponse>

}