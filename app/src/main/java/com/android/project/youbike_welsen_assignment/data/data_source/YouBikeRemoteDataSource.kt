package com.android.project.youbike_welsen_assignment.data.data_source

import com.android.project.youbike_welsen_assignment.data.data_class.YouBikeResp
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class YouBikeRemoteDataSource @Inject constructor(
    private val youBikeServiceApi: YouBikeServiceApi
) : YouBikeDataSource {
    override fun getYouBikeInform(): Single<List<YouBikeResp>> {
        return youBikeServiceApi.getYouBikeInform().subscribeOn(Schedulers.io())
    }
}