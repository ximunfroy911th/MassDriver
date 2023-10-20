package net.unboxit.massrfid.model

import com.google.gson.annotations.SerializedName

data class ReceiveQualityResponse(
    @SerializedName("receiveQualityId")
    val receiveQualityId: Int,
    @SerializedName("projectId")
    val projectId: String,
    @SerializedName("qualityCode")
    val qualityCode: String,
    @SerializedName("qualityName")
    val qualityName: String,
)
