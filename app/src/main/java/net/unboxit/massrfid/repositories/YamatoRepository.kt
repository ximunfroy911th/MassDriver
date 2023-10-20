package net.unboxit.massrfid.repositories

import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import net.unboxit.massrfid.common.network.BaseApiResponse
import net.unboxit.massrfid.common.network.NetworkResult
import net.unboxit.massrfid.common.network.YamatoRemoteDataSource
import net.unboxit.massrfid.model.ReceiveQualityResponse
import javax.inject.Inject

@ActivityRetainedScoped
class YamatoRepository @Inject constructor(
    private val remoteDataSource: YamatoRemoteDataSource
): BaseApiResponse() {
    suspend fun getReceiveQuality(): Flow<NetworkResult<ReceiveQualityResponse>> {
        return flow {
            emit(safeApiCall{ remoteDataSource.getReceiveQuality() })
        }.flowOn(Dispatchers.IO)
    }
}