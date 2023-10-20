package net.unboxit.massrfid.common.network

import javax.inject.Inject

class DogRemoteDataSource @Inject constructor(private val dogService: DogService) {
    suspend fun getDog() = dogService.getDog()
}
