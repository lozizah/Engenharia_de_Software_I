package com.example.prj_plants_catalog.screens.dashboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prj_plants_catalog.databinding.CardDashboardItemsBinding

class AdapterDashboard : RecyclerView.Adapter<AdapterDashboard.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(CardDashboardItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

    }

    override fun getItemCount(): Int = 3

    class Holder(binding: CardDashboardItemsBinding) : RecyclerView.ViewHolder(binding.root)

}