package com.ewbugs.learningbottomnavigationbarkotlin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ewbugs.learningbottomnavigationbarkotlin.databinding.FragmentWeightBinding


class WeightFragment : Fragment() {

    private lateinit var binding: FragmentWeightBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentWeightBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpClickListeners()




    }
    private fun setUpClickListeners(){

        binding.containerWeight1.setOnClickListener { launchWeightRecordScreen("milligram") }
        binding.containerWeight2.setOnClickListener { launchWeightRecordScreen("microgram") }
        binding.containerWeight3.setOnClickListener { launchWeightRecordScreen("gram") }
        binding.containerWeight4.setOnClickListener { launchWeightRecordScreen("kilogram") }

    }

    private fun launchWeightRecordScreen(unit: String) {

        val intent = Intent(context, EditWeightRecordActivity::class.java)
        intent.putExtra("Unit", unit)
        startActivity(intent)
    }


}