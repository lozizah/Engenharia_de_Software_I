package com.example.prj_plants_catalog.screens.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.prj_plants_catalog.databinding.ActivityDashboardBinding
import com.example.prj_plants_catalog.screens.auth.ActivityEmailLogin
import com.example.prj_plants_catalog.screens.dashboard.adapter.AdapterDashboard
import com.example.prj_plants_catalog.utils.FirebaseAuthentication

class ActivityDashboard : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var firebaseAuth: FirebaseAuthentication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAuth = FirebaseAuthentication(this)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Exemplos pra mostrar pra princesa do grupo
        with(binding) {
            OptionList.adapter = AdapterDashboard()
            ButtonLogout.setOnClickListener {
                firebaseAuth.signOut()
                startActivity(Intent(this@ActivityDashboard, ActivityEmailLogin::class.java))
            }
        }
    }
}