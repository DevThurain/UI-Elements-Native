package com.thurainx.commonui.coordinator_layout

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thurainx.commonui.R
import com.thurainx.commonui.material_components.MaterialComponentsActivity

class CoordinatorLayoutActivity : AppCompatActivity() {

    companion object{
        fun getIntent(context: Context) : Intent {
            return Intent(context, CoordinatorLayoutActivity::class.java)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator_layout)
    }
}