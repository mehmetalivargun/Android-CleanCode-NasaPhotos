package com.mehmetalivargun.quotes.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mehmetalivargun.core.ui.BaseFragment
import com.mehmetalivargun.core.ui.BaseViewModel
import com.mehmetalivargun.domain.model.DailyImage
import com.mehmetalivargun.quotes.R
import com.mehmetalivargun.quotes.databinding.FragmentHomeBinding
import com.mehmetalivargun.quotes.ui.home.adapter.ImagesAdapter
import com.mehmetalivargun.quotes.ui.home.adapter.ImagesAdapterCallback
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home),
    ImagesAdapterCallback {
    override val viewModel: HomeViewModel by viewModels()
    private val adapter = ImagesAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModelFields()
        binding.imagesRecyclerView.adapter = adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState==null)
            viewModel.getDailyImages()
    }

    private fun observeViewModelFields(){
        with(viewModel){
            viewStateData.observe(viewLifecycleOwner){
              adapter.submitList(it.getItems().asReversed())
            }
            uiStateData.observe(viewLifecycleOwner){
                if(it.isLoading()){
                    binding.progressBar.visibility=View.VISIBLE
                    binding.imagesRecyclerView.visibility=View.GONE
                }
                if(it.isSuccess()){
                    binding.progressBar.visibility=View.GONE
                    binding.imagesRecyclerView.visibility=View.VISIBLE
                }
            }

        }
    }

    override fun onItemClick(image: DailyImage) {
        findNavController().navigate(R.id.action_homeFragment_to_imageDetailFragment, bundleOf(
            "imageUrl" to image.hdurl
        ))
    }


}