package aziz.academy.data.di

import aziz.academy.data.network.RatingPageService
import aziz.academy.data.repository.RatingRepositoryImpl
import aziz.academy.domain.repository.RatingRepository
import aziz.academy.domain.useCase.RatingPageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RatingModule {

    @[Provides Singleton]
    fun provideRatingService(retrofit: Retrofit): RatingPageService {
        return retrofit.create(RatingPageService::class.java)
    }

    @[Provides Singleton]
    fun provideRatingRepository(service: RatingPageService): RatingRepository {
        return RatingRepositoryImpl(service)
    }

    @[Provides Singleton]
    fun provideRatingUseCase(repository: RatingRepository): RatingPageUseCase {
        return RatingPageUseCase(repository)
    }

}