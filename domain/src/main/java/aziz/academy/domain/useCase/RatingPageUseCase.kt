package aziz.academy.domain.useCase

import aziz.academy.domain.repository.RatingRepository
import javax.inject.Inject

class RatingPageUseCase @Inject constructor(private val repository: RatingRepository) {

    suspend fun getRatings() = repository.getRating()

}