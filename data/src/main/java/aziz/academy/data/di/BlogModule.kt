package aziz.academy.data.di

import aziz.academy.data.network.BlogPageService
import aziz.academy.data.repository.BlogRepositoryImpl
import aziz.academy.domain.repository.BlogRepository
import aziz.academy.domain.useCase.BlogPageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BlogModule {

    @[Provides Singleton]
    fun provideBlogService(retrofit: Retrofit): BlogPageService {
        return retrofit.create(BlogPageService::class.java)
    }

    @[Provides Singleton]
    fun provideBlogRepository(service: BlogPageService): BlogRepository {
        return BlogRepositoryImpl(service)
    }

    @[Provides Singleton]
    fun provideBlogUseCase(repository: BlogRepository): BlogPageUseCase {
        return BlogPageUseCase(repository)
    }

}