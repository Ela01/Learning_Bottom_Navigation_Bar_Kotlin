package com.ewbugs.learningbottomnavigationbarkotlin.weight

import android.content.Context
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
        displayRecords()
    }

    override fun onResume() {
        super.onResume()
        displayRecords()
    }

    private fun setUpClickListeners(){
        binding.containerWeight1.setOnClickListener { launchWeightRecordScreen("Weight") }
        binding.containerWeight2.setOnClickListener { launchWeightRecordScreen("Neck Measurement") }
        binding.containerWeight3.setOnClickListener { launchWeightRecordScreen("Hips Measurement") }
        binding.containerWeight4.setOnClickListener { launchWeightRecordScreen("Waist Measurement") }

    }

    private fun displayRecords() {
        val weightPreferences = requireContext().getSharedPreferences("measurement", Context.MODE_PRIVATE)

        binding.textViewValue1.text = weightPreferences.getString("Weight Record", null)
        binding.textViewDate1.text = weightPreferences.getString("Weight Date", null)
        binding.textViewValue2.text = weightPreferences.getString("Neck Measurement Record", null)
        binding.textViewDate2.text = weightPreferences.getString("Neck Measurement Date", null)
        binding.textViewValue3.text = weightPreferences.getString("Hips Measurement Record", null)
        binding.textViewDate3.text = weightPreferences.getString("Hips Measurement Date", null)
        binding.textViewValue4.text = weightPreferences.getString("Waist Measurement Record", null)
        binding.textViewDate4.text = weightPreferences.getString("Waist Measurement Date", null)

    }

    private fun launchWeightRecordScreen(measurement: String) {

        val intent = Intent(context, EditWeightRecordActivity::class.java)
        intent.putExtra("Measurement", measurement)
        startActivity(intent)
    }


}