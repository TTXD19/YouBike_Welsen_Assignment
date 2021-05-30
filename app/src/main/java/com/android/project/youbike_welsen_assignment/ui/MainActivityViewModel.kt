package com.android.project.youbike_welsen_assignment.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.project.youbike_welsen_assignment.data.data_class.YouBikeResp
import com.android.project.youbike_welsen_assignment.data.repository.IYouBikeRepository
import com.android.project.youbike_welsen_assignment.data.repository.YouBikeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val youBikeRepository: YouBikeRepository
) : ViewModel() {

    val youBikeData = MutableLiveData<List<YouBikeResp>>()

    fun getData() {
        youBikeRepository.getYouBikeInform().subscribeBy {
            youBikeData.postValue(it)
        }
    }
}