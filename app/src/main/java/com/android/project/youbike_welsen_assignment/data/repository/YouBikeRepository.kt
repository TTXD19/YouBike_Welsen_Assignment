package com.android.project.youbike_welsen_assignment.data.repository

import com.android.project.youbike_welsen_assignment.data.data_class.YouBikeResp
import com.android.project.youbike_welsen_assignment.data.data_source.YouBikeRemoteDataSource
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class YouBikeRepository @Inject constructor(
    private val youBikeRemoteDataSource: YouBikeRemoteDataSource
) : IYouBikeRepository {
    override fun getYouBikeInform(): Single<DataResult<List<YouBikeResp>>> {
        return youBikeRemoteDataSource.getYouBikeInform().mapToResult()
    }

    private fun <T> Single<T>.mapToResult(): Single<DataResult<T>> {
        return map<DataResult<T>> {
            DataResult.Success(it)
        }.onErrorReturn {
            DataResult.Failure()
        }
    }
}