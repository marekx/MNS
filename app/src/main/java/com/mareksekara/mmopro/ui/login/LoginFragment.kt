package com.mareksekara.mmopro.ui.login

import android.os.Bundle
import com.mareksekara.mmopro.R
import com.mareksekara.mmopro.databinding.FragmentLoginBinding
import com.mareksekara.mmopro.ui.base.BaseFragment

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {

    override fun getFragmentView() = R.layout.fragment_home

    override fun getViewModel() = LoginViewModel::class.java

    override fun getNavViewVisible(): Boolean {
        return false
    }
}