package com.example.prj_plants_catalog.screens.catalogs.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.prj_plants_catalog.R
import com.example.prj_plants_catalog.databinding.FragmentAddPlantsBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetDialog(val typeCatalog: TypeCatalog) : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentAddPlantsBinding

    companion object {
        const val TAG = "BottomSheetFragmentDialogCatalogs"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, R.style.AppBottomSheetDialogTheme)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAddPlantsBinding.inflate(layoutInflater)
        if (typeCatalog == TypeCatalog.PLANTS) return inflater.inflate(R.layout.fragment_add_plants, container, false)
        else return inflater.inflate(R.layout.fragment_add_fertilizer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            ButtonAdd.setOnClickListener { dismissAllowingStateLoss() }
        }
    }

    enum class TypeCatalog {
        PLANTS,
        FERTILIZERS
    }
}