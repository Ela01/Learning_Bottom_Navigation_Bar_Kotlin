package com.ewbugs.learningbottomnavigationbarkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.commit
import com.ewbugs.learningbottomnavigationbarkotlin.databinding.ActivityMainBinding
import com.ewbugs.learningbottomnavigationbarkotlin.time.TimeFragment
import com.ewbugs.learningbottomnavigationbarkotlin.weight.WeightFragment

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
//first menu is the ui menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId){
    //item: MenuItem <- These are the things the user clicks
    //item.itemId is the property on these menu Items, it is how we inspect, which one they clicked
    //if (item.itemId == R.id.reset_running) { }
    //else if (item.itemId == R.id.reset_cycling) { } //but we will use a 'when-expression' because it is concise and less verbose:

        R.id.reset_weight -> {
            Toast.makeText(this, "clicked the reset weight menu item", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.reset_time -> {
            Toast.makeText(this, "clicked the reset time menu item", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.reset_temperature -> {
            Toast.makeText(this, "clicked the reset temperature menu item", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.reset_all -> {
            Toast.makeText(this, "clicked the reset all menu item", Toast.LENGTH_SHORT).show()
            true
        }
        else -> {
            /*
             It is possible to implement option menus specifically for individual fragments
            This line below is where, this 'returning', of the original implementation return in the code is implemented in.
             It is implemented in the app compat activity by default.
             You want to keep this code in.
             If we don't 'consume' the menu, click here.
             In the activity, we want to return this code, the default activity code for on options items, select it.
             And that will take care of allowing other parts of our app to capture the menu items.
            */
            super.onOptionsItemSelected(item)
        }
    }

    private fun onWeightClicked(): Boolean {

        supportFragmentManager.commit {
            //'add' will put one frame layout on top of the other. We don't want this
            replace(R.id.fragment_content, WeightFragment())
        }
        return true
    }

    private fun onTimeClicked(): Boolean {

        supportFragmentManager.commit {
            replace(R.id.fragment_content, TimeFragment())
        }
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem) = when (item.itemId){
        R.id.nav_ic_time -> onTimeClicked()
        R.id.nav_ic_weight -> onWeightClicked()
        else -> false
    }

}