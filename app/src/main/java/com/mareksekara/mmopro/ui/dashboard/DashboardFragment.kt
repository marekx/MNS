package com.mareksekara.mmopro.ui.dashboard

import android.os.Bundle
import androidx.lifecycle.Observer
import com.mareksekara.mmopro.R
import com.mareksekara.mmopro.databinding.FragmentDashboardBinding
import com.mareksekara.mmopro.ui.base.BaseFragment

class DashboardFragment : BaseFragment<FragmentDashboardBinding, DashboardViewModel>() {

    override fun getFragmentView() = R.layout.fragment_dashboard

    override fun getViewModel() = DashboardViewModel::class.java

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.text.observe(viewLifecycleOwner, {
            binding.textDashboard.text = it
        })
    }

    override fun getNavViewVisible(): Boolean {
        return true
    }
}