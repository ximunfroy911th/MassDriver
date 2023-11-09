package net.unboxit.massrfid.ui.scanning

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.unboxit.massrfid.model.ItemBox
import javax.inject.Inject

@HiltViewModel
class ScanViewModel @Inject constructor() : ViewModel() {
    val sim_items: List<ItemBox> = listOf(ItemBox("12321312230000", false),
        ItemBox("12321312230001", false),
        ItemBox("12321312230002", false),
        ItemBox("12321312230003", false),
        ItemBox("12321312230004", false),
        ItemBox("12321312230005", false),
        ItemBox("12321312230006", false),
        ItemBox("12321312230007", false),
        ItemBox("12321312230008", false),
        ItemBox("12321312230009", false),
        ItemBox("12321312230010", false),
        ItemBox("12321312230020", false),
        ItemBox("12321312230030", false),
        ItemBox("12321312230040", false),
        ItemBox("12321312230050", false),
        ItemBox("12321312230060", false),
        ItemBox("12321312230070", false),
        ItemBox("12321312230080", false),
        ItemBox("12321312230090", false),
        ItemBox("12321312230100", false),)
    fun simScan() {
        viewModelScope.launch {
            sim_items.forEach { 
                delay(100)
                it.checked = true
                _items.postValue(sim_items)
            }
        }
    }

    private val _items: MutableLiveData<List<ItemBox>> = MutableLiveData()
    val items: LiveData<List<ItemBox>> = _items

    init {
        _items.postValue(sim_items)
    }
}
