package com.android.project.youbike_welsen_assignment.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.project.youbike_welsen_assignment.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    private val youBikeAdapter = YouBikeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }

        binding.rvBikeInformation.run {
            layoutManager = LinearLayoutManager(context)
            adapter = youBikeAdapter
        }

        viewModel.getData()
        viewModel.youBikeData.observe(this) {
            youBikeAdapter.submitList(it)
        }
    }
}