package com.example.prj_plants_catalog.screens.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.prj_plants_catalog.databinding.ActivityDashboardBinding
import com.example.prj_plants_catalog.screens.dashboard.adapter.AdapterDashboard

class ActivityDashboard : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Exemplos pra mostrar pra princesa do grupo
        binding.OptionList.adapter = AdapterDashboard()
    }
}