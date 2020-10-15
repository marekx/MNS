package com.mareksekara.mmopro.ui.mainActivity

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.transition.Slide
import androidx.transition.TransitionManager
import com.mareksekara.mmopro.R
import com.mareksekara.mmopro.databinding.ActivityMainBinding
import com.mareksekara.mmopro.ui.login.LoginFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentManager: FragmentManager
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentManager = supportFragmentManager

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        binding.lifecycleOwner = this
        setupNavBar()
    }

    override fun onResume() {
        super.onResume()
        navHostFragment.navController.navigate(R.id.navigation_login)
    }

    private fun setupNavBar(){

        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        setupActionBarWithNavController(
            navHostFragment.navController,
            AppBarConfiguration(
                setOf(
                    R.id.navigation_home,
                    R.id.navigation_dashboard,
                    R.id.navigation_notifications,
                    R.id.navigation_login
                )
            )
        )

        binding.navView.setupWithNavController(navHostFragment.navController)
    }

    fun setNavBarVisible(visible: Boolean){

        if(!visible){
            TransitionManager.beginDelayedTransition(binding.container, Slide(Gravity.BOTTOM).excludeTarget(R.id.nav_host_fragment, true))
            binding.navView.visibility = View.GONE
        }else {
            binding.navView.visibility = View.VISIBLE
        }
    }
}