package com.mareksekara.mmopro.ui.login

import android.app.Activity
import android.content.Context
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.databinding.ObservableBoolean
import androidx.databinding.adapters.TextViewBindingAdapter
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.mareksekara.mmopro.ui.repository.AuthRepository

class LoginViewModel @ViewModelInject constructor(
    private val repository: AuthRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private lateinit var userEmailAddress: String
    private lateinit var userPassword: String

    private var buttonEnabled = ObservableBoolean(false)

    fun onSendAction(): TextView.OnEditorActionListener {
        return TextView.OnEditorActionListener { view, actionId, _ ->
            when (actionId) {
                EditorInfo.IME_ACTION_DONE -> login(view.context)
            }
            true
        }
    }

    fun emailTextChanged(): TextViewBindingAdapter.OnTextChanged {
        return TextViewBindingAdapter.OnTextChanged { charSequence, _, _, _ ->
            userEmailAddress = charSequence.toString()
            buttonEnabled.set(userPassword.isNotEmpty() && userEmailAddress.isNotEmpty())
        }
    }

    fun passwordTextChanged(): TextViewBindingAdapter.OnTextChanged {
        return TextViewBindingAdapter.OnTextChanged { charSequence, _, _, _ ->
            userPassword = charSequence.toString()
            buttonEnabled.set(userPassword.isNotEmpty() && userEmailAddress.isNotEmpty())
        }
    }

    fun login(context: Context) {
        Firebase.auth.signInWithEmailAndPassword(userEmailAddress, userPassword)
            .addOnCompleteListener { task ->
                if (task.isComplete) {

                } else {

                }
            }
    }
}