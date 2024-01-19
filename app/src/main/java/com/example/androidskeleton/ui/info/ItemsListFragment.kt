package com.example.androidskeleton.ui.info

import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.androidskeleton.R
import com.example.androidskeleton.databinding.FragmentItemsListBinding
import com.example.androidskeleton.ui.base.BaseFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class ItemsListFragment : BaseFragment<FragmentItemsListBinding, AdsViewModel>(FragmentItemsListBinding::inflate)
     {


    override val viewModel: AdsViewModel by viewModels()

    override fun initView(binding: FragmentItemsListBinding, savedInstanceState: Bundle?) {

        binding.fabAddProduct.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_addItemFragment)
        }
    }

    override fun observeViewModel(viewModel: AdsViewModel) {
        viewModel.getInfoByApi()
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.tasksEvent.collect {
                when (it) {

                    is AdsViewModel.AdsEvent.UpdateTitle -> {
                        //binding.overview.title.text = it.title
                    }


                    is AdsViewModel.AdsEvent.Error -> {
                        Toast.makeText(context, it.error.message, Toast.LENGTH_SHORT).show()
                    }

                    is AdsViewModel.AdsEvent.Loading -> {
                        //binding.progressbar.isVisible = it.loading
                    }

                    else -> {}
                }
            }
        }
    }

}