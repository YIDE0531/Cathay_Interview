package com.nuu.cathay_interview.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.nuu.cathay_interview.R
import com.nuu.cathay_interview.databinding.ListItemPlantBinding
import com.nuu.cathay_interview.model.PlantItem
import com.nuu.cathay_interview.model.PlantItemResults
import com.nuu.cathay_interview.ui.main.DistrictDetailFragmentDirections
import com.nuu.cathay_interview.ui.main.DistrictDetailViewModel

class PlantAdapter (private val viewModel: DistrictDetailViewModel, private val context: Context?): RecyclerView.Adapter<PlantAdapter.PlantHolder>() {
    private var plantItem: PlantItem? = null

    fun updateThumbInfoAllArray(list: PlantItem?){
        plantItem = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): PlantAdapter.PlantHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemPlantBinding.inflate(layoutInflater, parent, false)
        return PlantHolder(binding)
    }

    override fun onBindViewHolder(holder: PlantAdapter.PlantHolder, position: Int) {
        if (plantItem != null) {
            holder.bind(viewModel, plantItem?.result?.results!![position])
        }
    }

    override fun getItemCount(): Int {
        return if (plantItem == null) 0 else plantItem?.result?.results?.size!!
    }

    inner class PlantHolder(private val binding: ListItemPlantBinding): RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(viewModel: DistrictDetailViewModel, data: PlantItemResults?){
            binding.viewModel = viewModel
            binding.item = data
            binding.executePendingBindings()

            binding.constMain.setOnClickListener {
                val action = DistrictDetailFragmentDirections.actionDistrictDetailFragmentToPlantFragment(
                    item = data
                )
                Navigation.findNavController(binding.constMain).navigate(action)
            }
        }
    }
}
