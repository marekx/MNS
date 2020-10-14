package com.mareksekara.mmopro.ui.magicLink

import android.os.Bundle
import com.mareksekara.mmopro.R
import com.mareksekara.mmopro.databinding.FragmentMagicLinkBinding
import com.mareksekara.mmopro.ui.base.BaseFragment

class MagicLinkFragment : BaseFragment<FragmentMagicLinkBinding, MagicLinkViewModel>() {

    override fun getFragmentView() = R.layout.fragment_magic_link

    override fun getViewModel() = MagicLinkViewModel::class.java

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun getNavViewVisible(): Boolean {
        return false
    }
}