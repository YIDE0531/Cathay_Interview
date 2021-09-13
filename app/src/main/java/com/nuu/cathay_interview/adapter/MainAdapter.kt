package com.nuu.cathay_interview.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation

import androidx.recyclerview.widget.RecyclerView
import com.nuu.cathay_interview.R
import com.nuu.cathay_interview.databinding.ListItemDistrictBinding
import com.nuu.cathay_interview.model.DistrictItem
import com.nuu.cathay_interview.model.DistrictItemResults
import com.nuu.cathay_interview.ui.main.MainViewModel

class MainAdapter(private val viewModel: MainViewModel, private val context: Context?): RecyclerView.Adapter<MainAdapter.MainHolder>() {
    private var districtItem: DistrictItem? = null

    fun updateThumbInfoAllArray(list: DistrictItem?){
        districtItem = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MainAdapter.MainHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemDistrictBinding.inflate(layoutInflater, parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int) {
        if (districtItem != null) {
            holder.bind(viewModel, districtItem?.result?.results!![position])
        }
    }

    override fun getItemCount(): Int {
        return if (districtItem == null) 0 else districtItem?.result?.results?.size!!
    }

    inner class MainHolder(private val binding: ListItemDistrictBinding): RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(viewModel: MainViewModel, data: DistrictItemResults?){
            binding.viewModel = viewModel
            binding.item = data
            binding.executePendingBindings()

            binding.constMain.setOnClickListener {
                val bundle = Bundle()
                bundle.putSerializable("item", data)
                Navigation.findNavController(binding.constMain).navigate(R.id.action_mainFragment_to_summaryFragment, bundle)
            }
        }
    }
}
