package com.thurainx.commonui.constraint_layout

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thurainx.commonui.R
import com.thurainx.commonui.collapsing_tool_bar.CollapsingToolBarActivity

class ConstraintLayoutActivity : AppCompatActivity() {
    companion object{

        fun getIntent(context: Context) : Intent {
            return Intent(context, ConstraintLayoutActivity::class.java)
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout)
    }
}