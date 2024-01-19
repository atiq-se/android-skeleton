package com.example.androidskeleton.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidskeleton.R
import com.example.androidskeleton.databinding.FragmentSplashBinding
import com.example.androidskeleton.ui.base.BaseFragment
import com.example.androidskeleton.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint


/**
 * A simple [Fragment] subclass.
 * Use the [SplashFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class SplashFragment(override val viewModel: BaseViewModel) :
    BaseFragment<FragmentSplashBinding, BaseViewModel>(FragmentSplashBinding::inflate) {
    // Use the Navigation Controller to navigate to the next destination
    private val navController by lazy { findNavController() }

    // Optional: Add a delay before navigating to the next destination
    private val splashDelayMillis = 2000L // 2 seconds

    override fun observeViewModel(viewModel: BaseViewModel) {
    }

    override fun initView(binding: FragmentSplashBinding, savedInstanceState: Bundle?) {

       /* Handler(Looper.getMainLooper()).postDelayed({
            navController.navigate(R.id.action_splashFragment_to_FirstFragment)
        }, splashDelayMillis)*/
    }

    private fun navigateToNextDestination() {
        // Navigate to the next destination in the navigation graph

    }
}