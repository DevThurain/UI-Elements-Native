package com.thurainx.commonui.bottom_navigation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import com.thurainx.commonui.R
import com.thurainx.commonui.fragments.HomeFragment
import com.thurainx.commonui.fragments.NotificationFragment
import com.thurainx.commonui.fragments.SettingFragment
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigationActivity : AppCompatActivity() {


    companion object{
        fun getIntent(context: Context): Intent {
            return Intent(context, BottomNavigationActivity::class.java);
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        supportFragmentManager.beginTransaction()
            .add(R.id.flContainer, HomeFragment())
            .commit()

        bottomAppBar.setOnItemSelectedListener {
            menuItem ->

            when(menuItem.itemId){
                R.id.action_home -> {
                   switchFragment(HomeFragment())
                }
                R.id.action_notification -> {
                    switchFragment(NotificationFragment())

                }
                R.id.action_setting -> {
                    switchFragment(SettingFragment())
                }

            }

            return@setOnItemSelectedListener true

        }
    }

    private fun switchFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.flContainer, fragment)
            .commit()
    }
}