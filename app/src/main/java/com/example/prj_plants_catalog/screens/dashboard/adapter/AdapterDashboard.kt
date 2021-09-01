package com.example.prj_plants_catalog.screens.dashboard.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.prj_plants_catalog.R
import com.example.prj_plants_catalog.databinding.CardDashboardItemsBinding
import com.example.prj_plants_catalog.screens.catalogs.FertilizersActivity
import com.example.prj_plants_catalog.screens.catalogs.PlantsActivity

class AdapterDashboard : RecyclerView.Adapter<AdapterDashboard.Holder>() {
    private val list = listOf(
            CardDashboardAttributes(R.drawable.icon_wind, "Catálogo de plantas", "12 espécies disponíveis", "12 plantas",
                    PlantsActivity::class.java as Class<AppCompatActivity>),
            CardDashboardAttributes(R.drawable.icon_fertilizer, "Catálogo de adubos", "12 adubos disponíveis", "12 adubos",
                    FertilizersActivity::class.java as Class<AppCompatActivity>))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(CardDashboardItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = list[position]

        with(holder.binding) {
            Icon.setImageResource(item.iconResource)
            Title.text = item.tittle
            Subtittle.text = item.subtitle
            Observation.text = item.obs
            CardViewArea.setOnClickListener { holder.itemView.context.startActivity(Intent(holder.itemView.context, item.activity)) }
        }
    }

    override fun getItemCount(): Int = list.size

    class Holder(val binding: CardDashboardItemsBinding) : RecyclerView.ViewHolder(binding.root)

    data class CardDashboardAttributes(
            val iconResource: Int,
            val tittle: String,
            val subtitle: String,
            val obs: String,
            val activity: Class<AppCompatActivity>
    )

}