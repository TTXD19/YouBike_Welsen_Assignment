package com.android.project.youbike_welsen_assignment.di

import com.android.project.youbike_welsen_assignment.data.repository.IYouBikeRepository
import com.android.project.youbike_welsen_assignment.data.repository.YouBikeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindYouBikeRepository(youBikeRepository: YouBikeRepository): IYouBikeRepository
}