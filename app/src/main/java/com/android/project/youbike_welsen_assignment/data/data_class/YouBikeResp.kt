package com.android.project.youbike_welsen_assignment.data.data_class

import com.google.gson.annotations.SerializedName

data class YouBikeResp(
    @SerializedName("snaen")
    val location: String? = null,
    @SerializedName("tot")
    val totalBikes: String? = null,
    @SerializedName("sbi")
    val remainBikes: String? = null
)