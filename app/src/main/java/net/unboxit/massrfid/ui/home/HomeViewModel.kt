package net.unboxit.massrfid.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.unboxit.massrfid.common.network.NetworkResult
import net.unboxit.massrfid.model.DogResponse
import net.unboxit.massrfid.repositories.DogRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: DogRepository,
    application: Application
) : AndroidViewModel(application) {

    private val _response: MutableLiveData<NetworkResult<DogResponse>> = MutableLiveData()
    val response: LiveData<NetworkResult<DogResponse>> = _response

    fun fetchDogResponse() = viewModelScope.launch {
        repository.getDog().collect { values ->
            _response.value = values
        }
    }
}