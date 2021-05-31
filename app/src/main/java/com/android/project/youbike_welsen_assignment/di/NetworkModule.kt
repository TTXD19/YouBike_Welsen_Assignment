package com.android.project.youbike_welsen_assignment.di

import com.android.project.youbike_welsen_assignment.data.data_source.YouBikeServiceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideDefaultRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://data.ntpc.gov.tw/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideDefaultNetworkManager(
        retrofit: Retrofit
    ): DefaultNetworkManger {
        return DefaultNetworkManger(retrofit)
    }
}

@Module
@InstallIn(SingletonComponent::class)
object YouBikeServiceModule {

    @Singleton
    @Provides
    fun provideYouBikeServiceApi(
        defaultNetworkManger: DefaultNetworkManger
    ): YouBikeServiceApi {
        return defaultNetworkManger.getApiService(YouBikeServiceApi::class.java)
    }
}