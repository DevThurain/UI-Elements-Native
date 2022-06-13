package com.thurainx.commonui.material_components

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thurainx.commonui.R
import com.thurainx.commonui.bottom_sheet.BottomSheetActivity

class MaterialComponentsActivity : AppCompatActivity() {

    companion object{
        fun getIntent(context: Context) : Intent {
            return Intent(context, MaterialComponentsActivity::class.java)
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_components)
    }
}