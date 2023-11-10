package net.unboxit.massrfid.ui.selector

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import net.unboxit.massrfid.databinding.ActivitySelectorBinding

@AndroidEntryPoint
class SelectorActivity : AppCompatActivity() {
    private val viewModel by viewModels<SelectorViewModel>()
    private var _binding : ActivitySelectorBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySelectorBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}