package net.unboxit.massrfid.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import net.unboxit.massrfid.common.network.NetworkResult
import net.unboxit.massrfid.model.DogResponse
import net.unboxit.massrfid.model.LoggedInUser
import net.unboxit.massrfid.model.RecentlyJobModel
import net.unboxit.massrfid.model.UserPreferences
import net.unboxit.massrfid.repositories.DogRepository
import net.unboxit.massrfid.repositories.UserPreferencesRepository
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
//    private val dogRepository: DogRepository,
    private val userPreferencesRepository: UserPreferencesRepository,
    application: Application
) : AndroidViewModel(application) {

//    private val _response: MutableLiveData<NetworkResult<DogResponse>> = MutableLiveData()
//    val response: LiveData<NetworkResult<DogResponse>> = _response

    private val _loggedInUser: MutableLiveData<LoggedInUser> = MutableLiveData()
    val loggedInUser: LiveData<LoggedInUser> = _loggedInUser

    private val _userPreferences: MutableLiveData<UserPreferences> = MutableLiveData()
    val userPreferences: LiveData<UserPreferences> = _userPreferences

    private val _jobs: MutableLiveData<List<RecentlyJobModel>> = MutableLiveData()
    val jobs: LiveData<List<RecentlyJobModel>> = _jobs

//    fun fetchDogResponse() = viewModelScope.launch {
//        dogRepository.getDog().collect { values ->
//            _response.value = values
//        }
//    }
    init {
        _jobs.postValue(listOf(
            RecentlyJobModel("123","FUJI_OUTBOUND_20231001", false, Date()),
            RecentlyJobModel("456","FUJI_OUTBOUND_20231015", false, Date()),
            RecentlyJobModel("1234","FUJI_OUTBOUND_20231101", true, Date()),
            RecentlyJobModel("1233","FUJI_OUTBOUND_20231101", true, Date()),
        ))
    }

    fun getPreference() {
        viewModelScope.launch {
            userPreferencesRepository.userPreferencesFlow.collect { value ->
                _userPreferences.value = value
            }
        }
    }
}