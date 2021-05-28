package com.android.project.youbike_welsen_assignment.data.data_source

import com.android.project.youbike_welsen_assignment.data.data_class.YouBikeResp
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface YouBikeServiceApi {

    @GET("api/datasets/71CD1490-A2DF-4198-BEF1-318479775E8A/json/preview")
    fun getYouBikeInform(): Single<List<YouBikeResp>>
}