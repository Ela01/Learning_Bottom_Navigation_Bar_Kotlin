package com.ewbugs.learningbottomnavigationbarkotlin.weight

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
        displayRecords()
    }

    override fun onResume() {
        super.onResume()
        displayRecords()
    }

    private fun setUpClickListeners() {
        binding.containerWeight0.setOnClickListener { launchWeightRecordScreen("Height-cm/in") }
        binding.containerWeight1.setOnClickListener { launchWeightRecordScreen("Weight-kg/lb") }
        binding.containerWeight2.setOnClickListener { launchWeightRecordScreen("Neck-cm/in") }
        binding.containerWeight3.setOnClickListener { launchWeightRecordScreen("Hips-cm/in") }
        binding.containerWeight4.setOnClickListener { launchWeightRecordScreen("Waist-cm/in") }
    }

    private fun displayRecords() {
        val weightPreferences =
            requireContext().getSharedPreferences("weight", Context.MODE_PRIVATE)// to upper

        binding.textViewValue0.text = weightPreferences.getString("Height-cm/in record", null)
        binding.textViewDate0.text = weightPreferences.getString("Height-cm/in date", null)
        binding.textViewValue1.text = weightPreferences.getString("Weight-kg/lb record", null)
        binding.textViewDate1.text = weightPreferences.getString("Weight-kg/lb date", null)
        binding.textViewValue2.text = weightPreferences.getString("Neck-cm/in record", null)
        binding.textViewDate2.text = weightPreferences.getString("Neck-cm/in date", null)
        binding.textViewValue3.text = weightPreferences.getString("Hips-cm/in record", null)
        binding.textViewDate3.text = weightPreferences.getString("Hips-cm/in date", null)
        binding.textViewValue4.text = weightPreferences.getString("Waist-cm/in record", null)
        binding.textViewDate4.text = weightPreferences.getString("Waist-cm/in date", null)
    }

    private fun launchWeightRecordScreen(measurement: String) {
        val intent = Intent(context, EditWeightRecordActivity::class.java)
        intent.putExtra("Measurement", measurement)
        startActivity(intent)
    }
}