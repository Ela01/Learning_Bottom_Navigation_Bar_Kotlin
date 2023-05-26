package com.ewbugs.learningbottomnavigationbarkotlin.weight

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.ewbugs.learningbottomnavigationbarkotlin.databinding.ActivityEditWeightRecordBinding

class EditWeightRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditWeightRecordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditWeightRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val measurement = intent.getStringExtra("Measurement")
        title = "$measurement Record"

        displayRecord(measurement)
        binding.buttonSave.setOnClickListener {
            saveRecord(measurement)
            finish()

        }

    }

    private fun displayRecord(measurement: String?) {
        val weightPreferences = getSharedPreferences("measurement", Context.MODE_PRIVATE)

        binding.editTextRecord.setText(weightPreferences.getString("$measurement Record", null))
        binding.editTextDate.setText(weightPreferences.getString("$measurement Date", null))

    }

    private fun saveRecord(measurement: String?) {
        val record = binding.editTextRecord.text.toString()
        val date = binding.editTextDate.text.toString()

        val weightPreferences = getSharedPreferences("measurement", Context.MODE_PRIVATE)
        weightPreferences.edit {
            putString("$measurement Record", record)
            putString("$measurement Date", date)
        }


//        *** The 3 TYPES OF SHARED PREFERENCES ***

//        val applicationPreferences = PreferenceManager.getDefaultSharedPreferences(this)
//
//        applicationPreferences.edit {
//            putString("Some application data", "Application preference value here")
//        }
//
//        val activityPreferences = getPreferences(Context.MODE_PRIVATE)
//
//        activityPreferences.edit {
//            putInt("Some activity data", 32)
//        }
//
//        val fileNamePreferences = getSharedPreferences("some shared preference file name", Context.MODE_PRIVATE)
//        fileNamePreferences.edit {
//            putBoolean("Some preference file name data", false)
//        }


    }


}