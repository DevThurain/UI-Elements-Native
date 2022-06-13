package com.thurainx.commonui.bottom_appbar

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thurainx.commonui.R

class BottomAppBarActivity : AppCompatActivity() {

    companion object{
        fun getIntent(context: Context) : Intent{
            return Intent(context,BottomAppBarActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_app_bar)
    }
}