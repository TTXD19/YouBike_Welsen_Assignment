package com.android.project.youbike_welsen_assignment.ui

import android.util.Log
import androidx.lifecycle.ViewModel
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

    fun getData() {
        youBikeRepository.getYouBikeInform().subscribeBy {
            Log.d("testData", it[0].location!!)
        }
    }
}