package com.mareksekara.mmopro.ui.mainActivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.ActionCodeSettings
import com.google.firebase.auth.FirebaseAuth
import com.mareksekara.mmopro.R
import com.mareksekara.mmopro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val RC_SIGN_IN: Int = 1
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        binding.lifecycleOwner = this

        setupActionBarWithNavController(
            findNavController(R.id.nav_host_fragment),
            AppBarConfiguration(
                setOf(
                    R.id.navigation_home,
                    R.id.navigation_dashboard,
                    R.id.navigation_notifications
                )
            )
        )

        binding.navView.setupWithNavController(findNavController(R.id.nav_host_fragment))

        // Choose authentication providers
        //AuthUI.IdpConfig.PhoneBuilder().build()
        //AuthUI.IdpConfig.FacebookBuilder().build()
        //AuthUI.IdpConfig.TwitterBuilder().build()
    }

    override fun onResume() {
        super.onResume()

        val actionCodeSettings = ActionCodeSettings.newBuilder()
            .setAndroidPackageName("com.mareksekara.mmopro", true, null)
            .setHandleCodeInApp(true)
            .setUrl("https://mmo-pro.firebaseapp.com")
            .build()

        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder()
                .enableEmailLinkSignIn()
                .setActionCodeSettings(actionCodeSettings)
                .build(),
            AuthUI.IdpConfig.GoogleBuilder().build()
        )

        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build(),
            RC_SIGN_IN
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {

            val response = IdpResponse.fromResultIntent(data)

            if (resultCode == Activity.RESULT_OK) {
                // Successfully signed in
                val user = FirebaseAuth.getInstance().currentUser
                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }

        }
    }
}