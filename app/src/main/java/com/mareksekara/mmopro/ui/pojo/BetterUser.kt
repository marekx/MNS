package com.mareksekara.mmopro.ui.pojo

import com.google.firebase.firestore.Exclude
import java.io.Serializable

class BetterUser(

    val uid: String? = null,
    val name: String? = null,
    val email: String? = null,

    @Exclude var isAuthenticated: Boolean = false,
    @Exclude var isNew: Boolean = false,
    @Exclude var isCreated: Boolean = false

):Serializable