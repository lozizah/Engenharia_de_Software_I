package com.example.prj_plants_catalog.screens.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.prj_plants_catalog.databinding.ActivityEmailLoginBinding

class ActivityEmailLogin : AppCompatActivity() {
    private lateinit var binding: ActivityEmailLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}