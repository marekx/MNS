package com.mareksekara.mmopro.ui.home

import android.os.Bundle
import androidx.lifecycle.Observer
import com.mareksekara.mmopro.R
import com.mareksekara.mmopro.databinding.FragmentHomeBinding
import com.mareksekara.mmopro.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override fun getFragmentView() = R.layout.fragment_home

    override fun getViewModel() = HomeViewModel::class.java

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textHome.text = it
        })
    }
}