package com.mehmetalivargun.quotes.ui.imagedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mehmetalivargun.core.ui.BaseFragment
import com.mehmetalivargun.core.ui.BaseViewModel
import com.mehmetalivargun.quotes.R
import com.mehmetalivargun.quotes.databinding.FragmentImageDetailBinding
import com.mehmetalivargun.quotes.extensions.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageDetailFragment : BaseFragment<FragmentImageDetailBinding>(R.layout.fragment_image_detail) {
    override val viewModel: ImageDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModelFields()
    }

    private fun observeViewModelFields(){

        with(viewModel){
            viewStateData.observe(viewLifecycleOwner){
                binding.image.loadImage(it)
            }
        }
    }





}