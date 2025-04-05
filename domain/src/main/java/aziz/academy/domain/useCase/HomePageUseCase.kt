package aziz.academy.domain.useCase

import aziz.academy.domain.repository.HomeRepository
import javax.inject.Inject

class HomePageUseCase @Inject constructor(private val repository: HomeRepository) {

    suspend fun getHomeData() = repository.getHomeData()

}