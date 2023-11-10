package net.unboxit.massrfid.ui.selector

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.BaseAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import net.unboxit.massrfid.R
import net.unboxit.massrfid.databinding.FragmentReceiveEntryBinding
import net.unboxit.massrfid.model.ProcessType
import javax.inject.Inject

@AndroidEntryPoint
class ReceiveEntryFragment : Fragment() {

    private var _binding: FragmentReceiveEntryBinding? = null
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
        _binding = FragmentReceiveEntryBinding.inflate(inflater, container, false)

        val navController = findNavController()

        binding.btnRegister.setOnClickListener {
        }

        val items = listOf("Option1","Option2","Option3","Option4","Option5","Option6",)
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
        binding.acQualityCode.setAdapter(adapter)

        return binding.root
    }
}

class QualityCodeAdapter @Inject constructor(): BaseAdapter() {
    private val items:ArrayList<String> = arrayListOf<String>()
    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("Not yet implemented")
    }

}