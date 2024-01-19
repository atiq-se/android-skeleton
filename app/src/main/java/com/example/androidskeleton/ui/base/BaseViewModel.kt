package com.example.androidskeleton.ui.base

import androidx.lifecycle.ViewModel
import com.example.androidskeleton.data.repository.BaseRepository

abstract class BaseViewModel(private val repository: BaseRepository) : ViewModel() {
}