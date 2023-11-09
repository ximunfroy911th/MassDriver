package net.unboxit.massrfid.ui.scanning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import net.unboxit.massrfid.databinding.ActivityScanBinding
import net.unboxit.massrfid.ui.home.RecentlyJobAdapter
import javax.inject.Inject

@AndroidEntryPoint
class ScanActivity : AppCompatActivity() {

    private val viewModel by viewModels<ScanViewModel>()
    private var _binding: ActivityScanBinding? = null
    @Inject
    lateinit var itemScanAdapter: ItemScanAdapter
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityScanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvItems.adapter = itemScanAdapter
        viewModel.items.observe(this) {
            itemScanAdapter.updateItems(it)
            val enable = it.all { item ->
                item.checked
            }
            if(enable) {
                binding.btnConfirm.isEnabled = true
            }
        }
        binding.btnConfirm.setOnClickListener {
            finish()
        }
        binding.btnSimScan.setOnClickListener {
            viewModel.simScan()
        }
    }
}