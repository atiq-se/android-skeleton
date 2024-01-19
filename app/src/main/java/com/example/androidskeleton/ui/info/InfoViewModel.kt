package com.example.androidskeleton.ui.info

import androidx.lifecycle.viewModelScope
import com.example.androidskeleton.data.network.Resource
import com.example.androidskeleton.data.repository.MyRepository
import com.example.androidskeleton.data.responses.MyResponse
import com.example.androidskeleton.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdsViewModel @Inject constructor(private val repository: MyRepository) :
    BaseViewModel(repository) {

    private val tasksEventChannel = Channel<AdsEvent>()
    val tasksEvent = tasksEventChannel.receiveAsFlow()

    fun getInfoByApi() {
        viewModelScope.launch {
            tasksEventChannel.send(AdsEvent.Loading(true))
            when (val resource = repository.getInfoByApi()) {
                is Resource.Success -> {
                    populateData(resource.value)
                    tasksEventChannel.send(AdsEvent.Loading(false))
                }
                is Resource.Failure -> {
                    tasksEventChannel.send(AdsEvent.Error(resource.errorType, resource.error))
                }
                is Resource.Loading -> {
                    tasksEventChannel.send(AdsEvent.Loading(resource.loading))
                }
            }
        }
    }

    private suspend fun populateData(data: MyResponse) {
    }

    private suspend fun setTitle(title: String) {
        tasksEventChannel.send(AdsEvent.UpdateTitle(title))
    }

    private suspend fun setImage(imageUrl: String){
        tasksEventChannel.send(AdsEvent.UpdateImage(imageUrl))
    }

    sealed class AdsEvent {
        data class Error(val errorType: Int, val error: Throwable) : AdsEvent()
        data class Loading(val loading: Boolean) : AdsEvent()
        data class UpdateTitle(val title: String) : AdsEvent()
        data class UpdateImage(val imageUrl: String) : AdsEvent()
    }

}