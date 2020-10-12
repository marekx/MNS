package com.mareksekara.mmopro.ui.magicLink

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.ObservableBoolean
import androidx.databinding.adapters.TextViewBindingAdapter
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ActionCodeSettings
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.mareksekara.mmopro.R

class MagicLinkViewModel : ViewModel(){

    private lateinit  var userEmailAddress : String
    private var buttonEnabled = ObservableBoolean(false)

    fun onSendAction() : TextView.OnEditorActionListener {
        return TextView.OnEditorActionListener { view, actionId, _ ->
            when(actionId){
                EditorInfo.IME_ACTION_DONE -> sendMail(view.context)
            }
            true
        }
    }

    fun emailAddressTextChange() : TextViewBindingAdapter.OnTextChanged {
        return TextViewBindingAdapter.OnTextChanged { charSequence, _, _, _ ->
            userEmailAddress = charSequence.toString()
            buttonEnabled.set(charSequence?.isNotEmpty() ?: false)
        }
    }

    fun sendMail(context: Context) {
        val actionCodeSettings = ActionCodeSettings.newBuilder()
            .setAndroidPackageName("com.mareksekara.mmopro", true, null)
            .setHandleCodeInApp(true)
            .setUrl("https://mmo-pro.firebaseapp.com")
            .build()
        Firebase.auth.sendSignInLinkToEmail(userEmailAddress, actionCodeSettings)
        Toast.makeText(context, context.getString(R.string.email_sent), Toast.LENGTH_SHORT).show()
    }
}