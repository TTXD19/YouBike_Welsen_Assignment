package com.android.project.youbike_welsen_assignment.data.repository

import com.android.project.youbike_welsen_assignment.data.data_class.YouBikeResp
import io.reactivex.rxjava3.core.Single

interface IYouBikeRepository {
    fun getYouBikeInform(): Single<List<YouBikeResp>>
}