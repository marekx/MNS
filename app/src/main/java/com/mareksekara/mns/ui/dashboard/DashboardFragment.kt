package com.mareksekara.mns.ui.dashboard

import android.os.Bundle
import androidx.lifecycle.Observer
import com.mareksekara.mns.R
import com.mareksekara.mns.databinding.FragmentDashboardBinding
import com.mareksekara.mns.ui.base.BaseFragment

class DashboardFragment : BaseFragment<FragmentDashboardBinding, DashboardViewModel>() {

    override fun getFragmentView() = R.layout.fragment_dashboard

    override fun getViewModel() = DashboardViewModel::class.java

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textDashboard.text = it
        })
    }
}