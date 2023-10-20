package net.unboxit.massrfid.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import coil.load
import dagger.hilt.android.AndroidEntryPoint
import net.unboxit.massrfid.common.network.NetworkResult
import net.unboxit.massrfid.databinding.FragmentHomeBinding

@AndroidEntryPoint
class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fetchData()
    }

    private fun fetchData() {
        homeViewModel.fetchDogResponse()

        homeViewModel.response.observe(viewLifecycleOwner) { result ->
            when(result) {
                is NetworkResult.Success -> {
                    result.data?.let {
                        Log.d("Debug", it.message)
                        binding.ivDog.load(it.message) {
                            crossfade(true)
                        }
                        binding.tvTitle.text = "hello"
                    }
                }
                is NetworkResult.Error -> {}
                is NetworkResult.Loading -> {}
            }
        }
    }

}