package aziz.academy.domain.repository

import aziz.academy.core.handler.NetworkResult
import aziz.academy.domain.model.home.rating.RatingResult
import kotlinx.coroutines.flow.Flow

interface RatingRepository {

    suspend fun getRating(): Flow<NetworkResult<List<RatingResult>>>

}