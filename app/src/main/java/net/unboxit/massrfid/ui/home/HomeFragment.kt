package net.unboxit.massrfid.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import net.unboxit.massrfid.R
import net.unboxit.massrfid.databinding.FragmentHomeBinding
import net.unboxit.massrfid.model.RecentlyJobModel
import java.util.Date
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel by viewModels<HomeViewModel>()
    @Inject
    lateinit var recentlyJobAdapter: RecentlyJobAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        homeViewModel.userPreferences.observe(viewLifecycleOwner) { user ->
            if(user.accessToken.isEmpty()) {
                navController.navigate(R.id.loginActivity)
            }
        }
        recentlyJobAdapter.setOnClickListener(object : RecentlyJobAdapter.OnClickListener {
            override fun onClick(position: Int, model: RecentlyJobModel) {
                navController.navigate(R.id.scanActivity)
            }
        })
        homeViewModel.jobs.observe(viewLifecycleOwner) {
            recentlyJobAdapter.updateJobs(it)
        }
        binding.rvRecenlyJob.adapter = recentlyJobAdapter

//        homeViewModel.response.observe(viewLifecycleOwner) { result ->
//            when (result) {
//                is NetworkResult.Success -> {
//                    result.data?.let {
//                        Log.d("Debug", it.message)
//                        binding.ivDog.load(it.message) {
//                            crossfade(true)
//                        }
//                        binding.tvTitle.text = "hello"
//                    }
//                }
//
//                is NetworkResult.Error -> {}
//                is NetworkResult.Loading -> {}
//            }
//        }

        fetchData()
    }

    private fun fetchData() {

//        homeViewModel.fetchDogResponse()
        homeViewModel.getPreference()
    }

}