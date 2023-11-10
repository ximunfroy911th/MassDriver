package net.unboxit.massrfid.ui.selector

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import net.unboxit.massrfid.R
import net.unboxit.massrfid.databinding.FragmentSelectorJobBinding
import net.unboxit.massrfid.model.ProcessType

@AndroidEntryPoint
class JobSelectorFragment : Fragment() {

    private var _binding: FragmentSelectorJobBinding? = null
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
        _binding = FragmentSelectorJobBinding.inflate(inflater, container, false)

        val navController = findNavController()
        binding.btnSelectRegisterSerial.setOnClickListener {
            viewModel.setProcessType(ProcessType.REGISTER)
            navController.navigate(R.id.receiveEntryFragment)
        }
        binding.btnSelectInbound.setOnClickListener {
            viewModel.setProcessType(ProcessType.INBOUND)
            navController.navigate(R.id.receiveEntryFragment)
        }
        binding.btnSelectOutbound.setOnClickListener {
            viewModel.setProcessType(ProcessType.OUTBOUND)
            navController.navigate(R.id.receiveEntryFragment)
        }
        binding.btnSelectRescan.setOnClickListener {
            viewModel.setProcessType(ProcessType.RESCAN)
            navController.navigate(R.id.receiveEntryFragment)
        }

        return binding.root
    }
}