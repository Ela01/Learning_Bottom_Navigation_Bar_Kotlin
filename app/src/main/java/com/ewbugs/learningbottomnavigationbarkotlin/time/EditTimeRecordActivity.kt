package com.ewbugs.learningbottomnavigationbarkotlin.time

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ewbugs.learningbottomnavigationbarkotlin.databinding.ActivityEditTimeRecordBinding


class EditTimeRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditTimeRecordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditTimeRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val unit = intent.getStringExtra("Unit")
        title = "$unit Converter"
    }
}