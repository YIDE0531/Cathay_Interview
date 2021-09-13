package com.nuu.cathay_interview.ui.main

import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.nuu.cathay_interview.MainActivity
import com.nuu.cathay_interview.adapter.PlantAdapter
import com.nuu.cathay_interview.databinding.DistrictDetailFragmentBinding
import com.nuu.cathay_interview.model.DistrictItemResults


class DistrictDetailFragment : Fragment() {
    private val districtDetailViewModel: DistrictDetailViewModel by activityViewModels()
    private lateinit var districtDetailBinding: DistrictDetailFragmentBinding
    private lateinit var plantAdapter: PlantAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        districtDetailBinding = DistrictDetailFragmentBinding.inflate(layoutInflater)
        return districtDetailBinding.root
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        districtDetailBinding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = districtDetailViewModel
            districtDetailFragment = this@DistrictDetailFragment
        }

        val params = arguments?.getSerializable("item") as DistrictItemResults
        districtDetailBinding.item = params
        (activity as MainActivity).supportActionBar?.title = params.eName
        districtDetailViewModel.getPlantItem(params.eName)
        setRecyclerViewAdapter()
        setLink(params.eUrl ?: "", "在網頁開啟")

        if (params.eMemo.isNullOrEmpty()){
            districtDetailBinding.tvDistrictDate.visibility = View.GONE
        }
    }

    private fun setLink(link: String, text: String){    //設定超連結
        districtDetailBinding.tvDistrictLink.isClickable = true
        districtDetailBinding.tvDistrictLink.movementMethod = LinkMovementMethod.getInstance()
        val text = "<a href='${link}'>${text}</a>"
        districtDetailBinding.tvDistrictLink.text = Html.fromHtml(text)
    }


    private fun setRecyclerViewAdapter() {
        plantAdapter = PlantAdapter(districtDetailViewModel, context)
        districtDetailBinding.plantRecyclerView.apply {
            setHasFixedSize(true)
//            layoutManager = GridLayoutManager(context, 4)
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(  //加入底線
                    DividerItemDecoration(
                            context,
                            DividerItemDecoration.VERTICAL
                    )
            )
            adapter = plantAdapter
        }

        districtDetailViewModel.plantItemArray.observe(viewLifecycleOwner, {
            plantAdapter.updateThumbInfoAllArray(it)
        })
    }
}