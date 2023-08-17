package net.unboxit.massrfid.common.network

import net.unboxit.massrfid.common.Constants
import net.unboxit.massrfid.model.DogResponse
import retrofit2.Response
import retrofit2.http.GET

interface DogService {
    @GET(Constants.RANDOM_URL)
    suspend fun getDog(): Response<DogResponse>

}
