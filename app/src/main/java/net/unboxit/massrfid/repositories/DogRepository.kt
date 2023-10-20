package net.unboxit.massrfid.repositories

import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import net.unboxit.massrfid.common.network.BaseApiResponse
import net.unboxit.massrfid.common.network.DogRemoteDataSource
import net.unboxit.massrfid.common.network.NetworkResult
import net.unboxit.massrfid.model.DogResponse
import javax.inject.Inject

@ActivityRetainedScoped
class DogRepository @Inject constructor(
    private val remoteDataSource: DogRemoteDataSource
) : BaseApiResponse() {
    suspend fun getDog(): Flow<NetworkResult<DogResponse>> {
        return flow {
            emit(safeApiCall { remoteDataSource.getDog() })
        }.flowOn(Dispatchers.IO)
    }
}