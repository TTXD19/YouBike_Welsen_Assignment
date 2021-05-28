package com.android.project.youbike_welsen_assignment.di

import com.android.project.youbike_welsen_assignment.data.data_source.YouBikeRemoteDataSource
import com.android.project.youbike_welsen_assignment.data.data_source.YouBikeServiceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideYouBikeDataSource(
        youBikeServiceApi: YouBikeServiceApi
    ): YouBikeRemoteDataSource {
        return YouBikeRemoteDataSource(youBikeServiceApi)
    }
}