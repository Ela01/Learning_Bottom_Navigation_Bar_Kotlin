package com.ewbugs.learningbottomnavigationbarkotlin.weight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ewbugs.learningbottomnavigationbarkotlin.databinding.ActivityEditWeightRecordBinding

class EditWeightRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditWeightRecordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditWeightRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val unit = intent.getStringExtra("Unit")
        title = "$unit Converter"
    }
}