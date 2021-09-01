package com.example.prj_plants_catalog.screens.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.prj_plants_catalog.databinding.ActivityEmailLoginBinding
import com.example.prj_plants_catalog.screens.dashboard.ActivityDashboard
import com.example.prj_plants_catalog.utils.FirebaseAuthentication

class ActivityEmailLogin : AppCompatActivity() {
    private lateinit var binding: ActivityEmailLoginBinding
    private lateinit var firebaseAuth: FirebaseAuthentication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAuth = FirebaseAuthentication(this)
        binding = ActivityEmailLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val currentUser = firebaseAuth.currentUser()
        currentUser?.let {
            //TODO: Salvar os dados do usuário no UserDefaults que não existe ainda
            Log.i("Success:loginFirebase", currentUser.toString())
            startActivity(Intent(this, ActivityDashboard::class.java))
        }

        with(binding) {
            ButtonLogin.setOnClickListener {
                firebaseAuth.signIn(InputEmail.text.toString(), InputPassword.text.toString(), onSuccess = {
                    startActivity(Intent(this@ActivityEmailLogin, ActivityDashboard::class.java))
                }, onError = {
                    Toast.makeText(this@ActivityEmailLogin, "Usuário ou senha incorretos :(", Toast.LENGTH_SHORT).show()
                })
            }
            NotRegisteredAlready.setOnClickListener { startActivity(Intent(this@ActivityEmailLogin, ActivityEmailRegister::class.java)) }
        }
    }
}