package com.thurainx.commonui.bottom_navigation_with_viewpager

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.thurainx.commonui.R
import com.thurainx.commonui.bottom_navigation_with_viewpager.adapters.BottomNavigationViewPagerAdapter
import kotlinx.android.synthetic.main.activity_bottom_navigation_with_viewpager.*

class BottomNavigationWithViewPagerActivity : AppCompatActivity(){

    companion object{

        fun getIntent(context: Context) : Intent{
            return Intent(context,BottomNavigationWithViewPagerActivity::class.java)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation_with_viewpager)

        vpContainer.adapter = BottomNavigationViewPagerAdapter(this)

        vpContainer.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    when(position){
                        0 -> bottomAppBar.selectedItemId = R.id.action_home
                        1 -> bottomAppBar.selectedItemId = R.id.action_notification
                        2 -> bottomAppBar.selectedItemId = R.id.action_setting
                    }

                }
            }
        )

        bottomAppBar.setOnItemSelectedListener { menuItem: MenuItem ->

            when(menuItem.itemId){
                R.id.action_home -> {
                    vpContainer.currentItem = 0
                }
                R.id.action_notification -> {
                    vpContainer.currentItem = 1

                }
                R.id.action_setting -> {
                    vpContainer.currentItem = 2

                }
            }


            return@setOnItemSelectedListener true
        }
    }

}