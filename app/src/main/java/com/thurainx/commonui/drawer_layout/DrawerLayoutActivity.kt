package com.thurainx.commonui.drawer_layout

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.thurainx.commonui.R
import com.thurainx.commonui.coordinator_layout.CoordinatorLayoutActivity
import kotlinx.android.synthetic.main.activity_drawer_layout.*

class DrawerLayoutActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    companion object{
        fun getIntent(context: Context) : Intent {
            return Intent(context, DrawerLayoutActivity::class.java)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer_layout)

        setSupportActionBar(drawerToolBar)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            drawerToolBar,
            R.string.openDrawer,
            R.string.closeDrawer,
        )

        toggle.syncState()
        drawerNavigationView.setNavigationItemSelectedListener(this)

        btnStopLoading.setOnClickListener {
            swipeLayout.isRefreshing = false
        }

    }

    override fun onBackPressed() {
        when(drawerLayout.isDrawerOpen(GravityCompat.START)){
            true -> drawerLayout.closeDrawer(GravityCompat.START)
            else -> super.onBackPressed()
        }
        }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.actionHome -> {
                Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show()
                drawerLayout.closeDrawer(GravityCompat.START)
            }
        }
        return true
    }
}