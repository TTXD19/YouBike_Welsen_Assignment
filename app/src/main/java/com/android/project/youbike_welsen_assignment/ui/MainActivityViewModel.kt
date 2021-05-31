package com.android.project.youbike_welsen_assignment.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.project.youbike_welsen_assignment.data.data_class.YouBikeResp
import com.android.project.youbike_welsen_assignment.data.repository.DataResult
import com.android.project.youbike_welsen_assignment.data.repository.YouBikeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val youBikeRepository: YouBikeRepository
) : ViewModel() {

    val youBikeData = MutableLiveData<List<YouBikeResp>>()
    val viewEvent = MutableLiveData<ViewEvent>()

    fun getData() {
        youBikeRepository.getYouBikeInform().subscribeBy { data ->
            if (data is DataResult.Success) {
                youBikeData.postValue(data.data.sortedByDescending { it.date })
            } else {
                viewEvent.postValue(ViewEvent.OnError)
            }
        }
    }

    sealed class ViewEvent {
        object OnError : ViewEvent()
    }
}