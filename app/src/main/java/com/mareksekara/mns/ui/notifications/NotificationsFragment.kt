package com.mareksekara.mns.ui.notifications

import android.os.Bundle
import androidx.lifecycle.Observer
import com.mareksekara.mns.R
import com.mareksekara.mns.databinding.FragmentNotificationsBinding
import com.mareksekara.mns.ui.base.BaseFragment

class NotificationsFragment : BaseFragment<FragmentNotificationsBinding, NotificationsViewModel>() {

    override fun getFragmentView() = R.layout.fragment_notifications

    override fun getViewModel() = NotificationsViewModel::class.java

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textNotifications.text = it
        })
    }
}