package aziz.academy.domain.repository

import aziz.academy.core.handler.NetworkResult
import aziz.academy.domain.model.home.HomePageModel
import aziz.academy.domain.model.home.carousel.CarouselItem
import aziz.academy.domain.model.home.courses.Course
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    suspend fun getCourses(): Flow<NetworkResult<List<Course>>>

    suspend fun getCarousel(): Flow<NetworkResult<List<CarouselItem>>>

    suspend fun getHomeData(): Flow<NetworkResult<HomePageModel>>

}