package com.mareksekara.mns.ui.home

import android.os.Bundle
import androidx.lifecycle.Observer
import com.mareksekara.mns.R
import com.mareksekara.mns.databinding.FragmentHomeBinding
import com.mareksekara.mns.ui.base.BaseFragment

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