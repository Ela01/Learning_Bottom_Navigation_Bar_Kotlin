package com.ewbugs.learningbottomnavigationbarkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.commit
import com.ewbugs.learningbottomnavigationbarkotlin.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView


class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.setOnItemSelectedListener(this)

//        binding.buttonWeight.setOnClickListener { onWeightClicked() }
//        binding.buttonTime.setOnClickListener { onTimeClicked() }

    }

    private fun onWeightClicked() {

        supportFragmentManager.commit {
            //'add' will put one frame layout on top of the other. We don't want this
            replace(R.id.fragment_content, WeightFragment())
        }

    }

    private fun onTimeClicked() {

        supportFragmentManager.commit {
            replace(R.id.fragment_content, TimeFragment())
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.nav_ic_weight){
            onWeightClicked()
            return true
        } else if (item.itemId == R.id.nav_ic_time){
            onTimeClicked()
            return true
        } else {
            return false
        }
    }

}