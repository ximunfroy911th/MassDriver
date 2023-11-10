package net.unboxit.massrfid.ui.selector

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import net.unboxit.massrfid.R
import net.unboxit.massrfid.databinding.FragmentSelectorMainBinding
import net.unboxit.massrfid.model.CustomerType

@AndroidEntryPoint
class SelectorFragment : Fragment() {

    private var _binding: FragmentSelectorMainBinding? = null
    private val binding get() = _binding!!
    companion object {
        fun newInstance() = SelectorFragment()
    }

    private val viewModel by viewModels<SelectorViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSelectorMainBinding.inflate(inflater, container, false)

        val navController = findNavController()
        binding.btnSelectFuji.setOnClickListener {
            viewModel.setCustomer(CustomerType.FUJI)
            navController.navigate(R.id.jobSelectorFragment)
        }
        binding.btnSelectIsuzu.setOnClickListener {
            viewModel.setCustomer(CustomerType.ISUZU)
            navController.navigate(R.id.jobSelectorFragment)
        }

        return binding.root
    }

}