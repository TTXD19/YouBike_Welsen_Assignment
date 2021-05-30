package com.android.project.youbike_welsen_assignment.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.project.youbike_welsen_assignment.data.data_class.YouBikeResp
import com.android.project.youbike_welsen_assignment.databinding.ItemYouBikeInfoBinding
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class YouBikeAdapter : ListAdapter<YouBikeResp, YouBikeAdapter.YouBikeViewHolder>(
    YouBikeDiffCallBack()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YouBikeViewHolder {
        return YouBikeViewHolder(
            ItemYouBikeInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: YouBikeViewHolder, position: Int) {

        val data = currentList[position]
        holder.tvLocation.text = data.location
        holder.tvTotal.text = data.totalBikes
        holder.tvRemain.text = data.remainBikes
        holder.tvDate.text = data.date?.convertTimeFormat("yyyyMMddHHmmss", "yyyy/MM/dd HH:mm:ss")
    }


    inner class YouBikeViewHolder(private val binding: ItemYouBikeInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val tvLocation = binding.tvItemYouBikeLocationValue
        val tvTotal = binding.tvItemYouBikeTotalValue
        val tvRemain = binding.tvItemYouBikeLeftNumber
        val tvDate = binding.tvItemYouBikeDateValue
    }

    class YouBikeDiffCallBack : DiffUtil.ItemCallback<YouBikeResp>() {

        override fun areItemsTheSame(oldItem: YouBikeResp, newItem: YouBikeResp): Boolean {
            return oldItem.location == newItem.location
        }

        override fun areContentsTheSame(oldItem: YouBikeResp, newItem: YouBikeResp): Boolean {
            return oldItem == newItem
        }
    }

    fun String.convertTimeFormat(original: String, converted: String): String {
        val sdf = SimpleDateFormat(original, Locale.TAIWAN)
        val originDate = sdf.parse(this) ?: return ""
        sdf.applyPattern(converted)
        return try {
            sdf.format(originDate)
        } catch (e: ParseException) {
            ""
        }
    }
}