package aziz.academy.data.di

import aziz.academy.data.network.HomePageService
import aziz.academy.data.repository.HomeRepositoryImpl
import aziz.academy.domain.repository.HomeRepository
import aziz.academy.domain.useCase.HomePageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @[Provides Singleton]
    fun provideHomeRepository(service: HomePageService): HomeRepository {
        return HomeRepositoryImpl(service)
    }

    @[Provides Singleton]
    fun provideHomeUseCase(repository: HomeRepository): HomePageUseCase {
        return HomePageUseCase(repository)
    }

    @[Provides Singleton]
    fun provideCoursesService(retrofit: Retrofit): HomePageService {
        return retrofit.create(HomePageService::class.java)
    }
    
}