package com.example.prj_plants_catalog.utils

import android.app.Activity
import android.util.Log
import com.google.firebase.auth.ActionCodeSettings
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class FirebaseAuthentication(private val activity: Activity) {
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun currentUser(): FirebaseUser? {
        val currentUser = auth.currentUser
        if(currentUser != null){
            return currentUser
        }
        return null
    }

    fun createAccount(email: String, password: String, onSuccess: (user: FirebaseUser) -> Unit, onError: (exception: Exception?) -> Unit) =
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(activity) { task ->
            if (task.isSuccessful) {
                val user = auth.currentUser
                user?.sendEmailVerification()
                onSuccess(user!!)
            } else {
                Log.i("Error:loginFirebase", task.exception?.message!!)
                onError(task.exception)
            }
        }

    fun verifyEmailConfirmation(user: FirebaseUser) : Boolean {
        if (!user.isEmailVerified) {
            user.sendEmailVerification().addOnCompleteListener { task ->
                 if(!task.isSuccessful) Log.i("Error:firebaseSendEmailConfirmation", task.exception?.message.toString())
                 else Log.i("Success:firebaseSendEmailConfirmation", task.exception?.message.toString())
            }
            return false
        }
        return true
    }

    fun signIn(email: String, password: String, onSuccess: (user: FirebaseUser) -> Unit, onError: (exception: Exception?) -> Unit) =
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(activity) { task ->
            if (task.isSuccessful) {
                val user = auth.currentUser
                onSuccess(user!!)
            } else {
                Log.i("Error:loginFirebase", task.exception?.message!!)
                onError(task.exception)
            }
        }

    fun signOut() {
        auth.signOut()
    }

    fun newPassword(email: String, onSuccess: () -> Unit, onError: (exception: Exception?) -> Unit) {
        auth.sendPasswordResetEmail(email).addOnCompleteListener(activity) { task ->
            if(task.isSuccessful) {
                onSuccess()
            } else {
                Log.i("Error:resetPasswordFirebase", task.exception?.message!!)
                onError(task.exception)
            }
        }
    }
}