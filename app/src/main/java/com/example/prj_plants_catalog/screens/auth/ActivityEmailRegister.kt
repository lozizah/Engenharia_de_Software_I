package com.example.prj_plants_catalog.screens.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.prj_plants_catalog.databinding.ActivityEmailRegisterBinding
import com.example.prj_plants_catalog.screens.dashboard.ActivityDashboard
import com.example.prj_plants_catalog.utils.FirebaseAuthentication

class ActivityEmailRegister : AppCompatActivity() {
    private lateinit var binding: ActivityEmailRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuthentication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAuth = FirebaseAuthentication(this)
        binding = ActivityEmailRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            ButtonRegister.setOnClickListener {
                if(InputFirstPassword.text.toString() == InputSecondPassword.text.toString()) {
                    firebaseAuth.createAccount(InputEmail.text.toString(), InputFirstPassword.text.toString(), onSuccess = {
                        startActivity(Intent(this@ActivityEmailRegister, ActivityDashboard::class.java))
                    }, onError = {
                        Toast.makeText(this@ActivityEmailRegister, "Erro ao tentar realizar o registro :(", Toast.LENGTH_SHORT).show()
                    })
                } else Toast.makeText(this@ActivityEmailRegister, "As senhas informadas não são iguais", Toast.LENGTH_SHORT).show()
            }
            ButtonAlreadyRegistered.setOnClickListener { finish() }
        }
    }
}