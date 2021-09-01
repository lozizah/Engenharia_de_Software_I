package com.example.prj_plants_catalog.screens.catalogs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.prj_plants_catalog.databinding.ActivityCatalogBinding
import com.example.prj_plants_catalog.screens.catalogs.fragment.BottomSheetDialog

class PlantsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCatalogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatalogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            TextTittle.text = "Catálogo de plantas"
            Back.setOnClickListener { finish() }
            //TODO: Fazer o adapter do catálogo de plantas
            //ListCatalog.adapter =
            ButtonAdd.setOnClickListener {
                supportFragmentManager.let {
                    BottomSheetDialog(BottomSheetDialog.TypeCatalog.PLANTS).show(it, BottomSheetDialog.TAG)
                }
            }
        }
    }
}