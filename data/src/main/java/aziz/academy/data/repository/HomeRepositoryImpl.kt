package aziz.academy.data.repository

import aziz.academy.core.handler.NetworkResult
import aziz.academy.data.dto.courses.CoursesResponse
import aziz.academy.data.mapper.toDomain
import aziz.academy.data.network.HomePageService
import aziz.academy.domain.model.home.HomePageModel
import aziz.academy.domain.model.home.carousel.CarouselItem
import aziz.academy.domain.model.home.courses.Course
import aziz.academy.domain.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val apiService: HomePageService) :
    HomeRepository {

    override suspend fun getCourses(): Flow<NetworkResult<List<Course>>> = flow {

        emit(NetworkResult.Loading())

        try {
            val response = apiService.getCourses()
            if (response.isSuccessful) {
                response.body()?.let { dtoList ->
                    val courses = dtoList.results.map { it.toDomain() }
                    emit(NetworkResult.Success(courses))
                } ?: emit(NetworkResult.Error("Пустой ответ от сервера"))
            } else {
                emit(NetworkResult.Error("Ошибка сервера: ${response.code()}"))
            }
        } catch (e: Exception) {
            emit(NetworkResult.Error(e.localizedMessage ?: "Неизвестная ошибка"))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getCarousel(): Flow<NetworkResult<List<CarouselItem>>> = flow {

        emit(NetworkResult.Loading())

        try {

            val response = apiService.getCarousel()
            if (response.isSuccessful) {
                response.body()?.let { dtoList ->
                    val courses = dtoList.map { it.toDomain() }
                    emit(NetworkResult.Success(courses))
                } ?: emit(NetworkResult.Error("Пустой ответ от сервера"))
            } else {
                emit(NetworkResult.Error("Ошибка сервера: ${response.code()}"))
            }

        } catch (e: Exception) {
            emit(NetworkResult.Error(e.localizedMessage ?: "Something went wrong"))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getHomeData(): Flow<NetworkResult<HomePageModel>> =
        flow {

            emit(NetworkResult.Loading())

            try {

                val courseResponse = apiService.getCourses()
                val carouselResponse = apiService.getCarousel()

                if (courseResponse.isSuccessful && carouselResponse.isSuccessful) {


                    val courses = courseResponse.body()?.results?.map { it.toDomain() } ?: emptyList()
                    val carousel = carouselResponse.body()?.map { it.toDomain() } ?: emptyList()

                    emit(NetworkResult.Success(HomePageModel(courses, carousel)))
                }

            } catch (e: Exception) {
                emit(NetworkResult.Error(e.localizedMessage ?: "Something went wrong"))
            }


        }.flowOn(Dispatchers.IO)

}