package com.mareksekara.mmopro.ui.repository

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.mareksekara.mmopro.ui.pojo.User


public class AuthRepository {

    private val firebaseAuth = FirebaseAuth.getInstance()

    fun firebaseSignInWithEmail(email: String, password: String): MutableLiveData<User>? {
        val authenticatedUserMutableLiveData: MutableLiveData<User> = MutableLiveData<User>()
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if(it.isSuccessful){
                val isNewUser = it.result?.additionalUserInfo?.isNewUser
                if(isNewUser != null){
                    val firebaseUser = firebaseAuth.currentUser
                    if(firebaseUser != null){
                        val uid = firebaseUser.uid
                        val name = firebaseUser.displayName
                        val userEmail = firebaseUser.email

                        val user = User(uid, name, userEmail)
                        user.isNew = isNewUser
                        authenticatedUserMutableLiveData.value = user
                    }
                }
            }else {

            }
        }
        return authenticatedUserMutableLiveData
    }

}