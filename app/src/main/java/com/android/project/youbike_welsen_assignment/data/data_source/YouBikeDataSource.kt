package com.android.project.youbike_welsen_assignment.data.data_source

import com.android.project.youbike_welsen_assignment.data.data_class.YouBikeResp
import io.reactivex.rxjava3.core.Single

interface YouBikeDataSource {
    fun getYouBikeInform(): Single<List<YouBikeResp>>
}