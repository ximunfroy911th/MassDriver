package net.unboxit.massrfid.ui.selector

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import net.unboxit.massrfid.model.CustomerType
import net.unboxit.massrfid.model.ProcessType
import javax.inject.Inject

@HiltViewModel
class SelectorViewModel @Inject constructor(): ViewModel() {
    fun setCustomer(customerType: CustomerType) {
    }

    fun setProcessType(customerType: ProcessType) {
    }
}