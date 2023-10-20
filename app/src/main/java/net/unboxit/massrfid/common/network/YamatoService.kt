package net.unboxit.massrfid.common.network

import net.unboxit.massrfid.model.DogResponse
import net.unboxit.massrfid.model.ReceiveQualityResponse
import retrofit2.Response
import retrofit2.http.GET

interface YamatoService {
    @GET("/api/receiveQuality")
    suspend fun getReceiveQuality(): Response<ReceiveQualityResponse>
}