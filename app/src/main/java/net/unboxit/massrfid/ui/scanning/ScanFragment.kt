package net.unboxit.massrfid.ui.scanning

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import net.unboxit.massrfid.R
import net.unboxit.massrfid.databinding.FragmentScanBinding
import net.unboxit.massrfid.ui.home.HomeViewModel

@AndroidEntryPoint
class ScanFragment : Fragment() {

    private val scanViewModel by viewModels<ScanViewModel>()
    private var _binding : FragmentScanBinding? = null
    private val binding = _binding!!

    companion object {
        fun newInstance() = ScanFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}