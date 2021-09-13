package com.nuu.cathay_interview.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.nuu.cathay_interview.adapter.MainAdapter
import com.nuu.cathay_interview.databinding.MainFragmentBinding


class MainFragment : Fragment() {
    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var mainBinding: MainFragmentBinding
    private lateinit var mainAdapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainBinding = MainFragmentBinding.inflate(layoutInflater)
        return mainBinding.root
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainBinding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = mainViewModel
            mainFragment = this@MainFragment
        }

        setRecyclerViewAdapter()
    }

    private fun setRecyclerViewAdapter() {
        mainAdapter = MainAdapter(mainViewModel, context)
        mainBinding.mainRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(  //加入底線
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = mainAdapter
        }

        mainViewModel.districtItemArray.observe(viewLifecycleOwner, {
            mainAdapter.updateThumbInfoAllArray(it)
            mainBinding.mainProgressBar.visibility = View.GONE
        })
    }
}