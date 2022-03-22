package com.abhishek.sharedviewmodelexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.abhishek.sharedviewmodelexample.databinding.FragmentBookmarksBinding

class BookmarksFragment : Fragment() {
    private lateinit var binding: FragmentBookmarksBinding
    private lateinit var viewModel: MainViewModel
    private val urls = listOf(
        "https://facebook.com",
        "https://google.com",
        "https://instagram.com",
        "https://amazon.com",
        "https://walmart.com"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookmarksBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        binding.lvUrls.adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            urls
        )
        binding.lvUrls.setOnItemClickListener { _, _, position, _ ->
            viewModel.selectedUrl.postValue(urls[position])
        }
        return binding.root
    }
}