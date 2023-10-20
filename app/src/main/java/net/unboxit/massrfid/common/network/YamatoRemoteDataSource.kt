package net.unboxit.massrfid.common.network

import javax.inject.Inject

class YamatoRemoteDataSource @Inject constructor(
    private val yamatoService: YamatoService
) {
    suspend fun getReceiveQuality() = yamatoService.getReceiveQuality()
}