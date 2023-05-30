package com.ewbugs.learningbottomnavigationbarkotlin.weight

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.ewbugs.learningbottomnavigationbarkotlin.databinding.ActivityEditWeightRecordBinding

class EditWeightRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditWeightRecordBinding
    private val weightPreferences by lazy { getSharedPreferences("weight", Context.MODE_PRIVATE) }
    private val measurement by lazy { intent.getStringExtra("Measurement") }// check if 'Meas..' is lowercase?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditWeightRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
        displayRecord()
    }

    private fun setupUI() {
        title = "$measurement Record"
        binding.buttonSave.setOnClickListener {
            saveRecord()
            finish()
        }
        binding.buttonDelete.setOnClickListener {
            clearRecord()
            finish()
        }
    }

    private fun displayRecord() {
        binding.editTextRecord.setText(weightPreferences.getString("$measurement record", null))
        binding.editTextDate.setText(weightPreferences.getString("$measurement date", null))
    }

    private fun saveRecord() {
        val record = binding.editTextRecord.text.toString()
        val date = binding.editTextDate.text.toString()

        weightPreferences.edit {
            putString("$measurement record", record)
            putString("$measurement date", date)
        }
    }

    private fun clearRecord() {
        weightPreferences.edit {
            remove("$measurement record")
            remove("$measurement date")
        }
    }
}

//        *** The 3 TYPES OF SHARED PREFERENCES ***

//        val applicationPreferences = PreferenceManager.getDefaultSharedPreferences(this)
//        applicationPreferences.edit {
//            putString("Some application data", "Application preference value here")
//        }
//
//        val activityPreferences = getPreferences(Context.MODE_PRIVATE)
//        activityPreferences.edit {
//            putInt("Some activity data", 32)
//        }
//
//        val fileNamePreferences = getSharedPreferences("some shared preference file name", Context.MODE_PRIVATE)
//        fileNamePreferences.edit {
//            putBoolean("Some preference file name data", false)
//        }
