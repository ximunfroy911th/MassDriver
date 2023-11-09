package net.unboxit.massrfid.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.unboxit.massrfid.model.UserPreferences
import net.unboxit.massrfid.repositories.UserPreferencesRepository
import javax.inject.Inject

@HiltViewModel
class FullscreenViewModel @Inject constructor(
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {

    private val _preferences: MutableLiveData<UserPreferences> = MutableLiveData()
    val prefrences: LiveData<UserPreferences> = _preferences
    fun fetchPreferences() = viewModelScope.launch {
        userPreferencesRepository.userPreferencesFlow.collect {
            _preferences.value = it
        }
    }
}