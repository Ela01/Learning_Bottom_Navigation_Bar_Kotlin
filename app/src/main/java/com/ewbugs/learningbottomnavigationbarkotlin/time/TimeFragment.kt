package com.ewbugs.learningbottomnavigationbarkotlin.time

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ewbugs.learningbottomnavigationbarkotlin.databinding.FragmentTimeBinding

//cycling
class TimeFragment : Fragment() {

    private lateinit var binding: FragmentTimeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentTimeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpClickListeners()




    }
    private fun setUpClickListeners(){

        binding.containerTime1.setOnClickListener { launchTimeRecordScreen("seconds") }
        binding.containerTime2.setOnClickListener { launchTimeRecordScreen("hours") }
        binding.containerTime3.setOnClickListener { launchTimeRecordScreen("days") }
        binding.containerTime4.setOnClickListener { launchTimeRecordScreen("weeks") }
        binding.containerTime5.setOnClickListener { launchTimeRecordScreen("years") }


    }

    private fun launchTimeRecordScreen(unit: String) {

        val intent = Intent(context, EditTimeRecordActivity::class.java)
        intent.putExtra("Unit", unit)
        startActivity(intent)
    }


}