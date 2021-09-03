package com.example.prj_plants_catalog.screens.auth

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.prj_plants_catalog.databinding.ActivityNewPasswordBinding
import com.example.prj_plants_catalog.utils.FirebaseAuthentication

class ActivityNewPassword : AppCompatActivity() {
    private lateinit var binding: ActivityNewPasswordBinding
    private val firebaseAuth: FirebaseAuthentication by lazy { FirebaseAuthentication(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            ButtonBackToLoginScreen.setOnClickListener { finish() }
            ButtonSend.setOnClickListener {
                firebaseAuth.newPassword(InputEmail.text.toString(), onSuccess = {
                    Toast.makeText(this@ActivityNewPassword, "Um email de verificação será enviado para o e-mail informado" +
                            "\ncom as instruções para redefinição de senha", Toast.LENGTH_LONG).show()
                }, onError = {
                    Toast.makeText(this@ActivityNewPassword, "Occoreu um erro ao enviar o e-email de redefinição de senha :(" +
                            "\nConfirme se este e-mail já foi cadastrado", Toast.LENGTH_LONG).show()
                })
            }
        }
    }
}