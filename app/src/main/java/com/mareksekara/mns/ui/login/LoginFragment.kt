package com.mareksekara.mns.ui.login

import android.os.Bundle
import androidx.lifecycle.Observer
import com.mareksekara.mns.R
import com.mareksekara.mns.databinding.FragmentLoginBinding
import com.mareksekara.mns.ui.base.BaseFragment

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {

    override fun getFragmentView() = R.layout.fragment_home

    override fun getViewModel() = LoginViewModel::class.java

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }
}