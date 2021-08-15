package com.example.prj_plants_catalog.screens.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.prj_plants_catalog.databinding.ActivityOptionsLoginBinding

class ActivityLoginOptions : AppCompatActivity() {
    private lateinit var binding: ActivityOptionsLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOptionsLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.EmailButton.setOnClickListener {
            startActivity(Intent(this, ActivityEmailLogin::class.java))
        }
    }
}