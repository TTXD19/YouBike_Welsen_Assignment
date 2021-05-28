package com.android.project.youbike_welsen_assignment.di

import retrofit2.Retrofit

open class DefaultNetworkManger(
    private val retrofit: Retrofit
) {
    fun getRetrofit(): Retrofit {
        return retrofit
    }

    inline fun <reified T> getApiService(serviceClazz: Class<T>): T {
        return getRetrofit().create(serviceClazz)
    }

}