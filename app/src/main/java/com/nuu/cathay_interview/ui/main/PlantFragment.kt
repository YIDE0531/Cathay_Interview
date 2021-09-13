package com.nuu.cathay_interview.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.nuu.cathay_interview.MainActivity
import com.nuu.cathay_interview.databinding.PlantFragmentBinding
import com.nuu.cathay_interview.model.PlantItemResults

class PlantFragment : Fragment() {
    private val plantViewModel: PlantViewModel by activityViewModels()
    private lateinit var plantBinding: PlantFragmentBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        plantBinding = PlantFragmentBinding.inflate(layoutInflater)
        return plantBinding.root
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        plantBinding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = plantViewModel
            plantFragment = this@PlantFragment
        }

        val params = arguments?.getSerializable("item") as PlantItemResults
        plantBinding.item = params
        (activity as MainActivity).supportActionBar?.title = params.fNameCh
    }
}