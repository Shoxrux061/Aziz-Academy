package aziz.academy.data.repository

import android.util.Log
import aziz.academy.core.handler.NetworkResult
import aziz.academy.data.mapper.toDomain
import aziz.academy.data.network.RatingPageService
import aziz.academy.domain.model.home.rating.RatingResult
import aziz.academy.domain.repository.RatingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RatingRepositoryImpl @Inject constructor(private val service: RatingPageService) :
    RatingRepository {

    override suspend fun getRating(): Flow<NetworkResult<List<RatingResult>>> = flow {

        emit(NetworkResult.Loading())

        try {

            val ratingResponse = service.getRatings()

            if (ratingResponse.isSuccessful) {
                val body = ratingResponse.body()
                if (body != null) {
                    val ratingList = body.results.map { it.toDomain() }
                    Log.d("TAGRepositoryRating", "Success $body")
                    emit(NetworkResult.Success(ratingList))
                } else {
                    Log.d("TAGRepositoryRating", "Failure ${ratingResponse.errorBody()}")
                    emit(NetworkResult.Error("Пустой ответ от сервера"))
                }
            }

        } catch (e: Exception) {
            Log.d("TAGRepositoryRating", "Failure Catch ${e.localizedMessage}")
            emit(NetworkResult.Error(e.localizedMessage ?: "Something went wrong"))
        }
    }.flowOn(Dispatchers.IO)

}