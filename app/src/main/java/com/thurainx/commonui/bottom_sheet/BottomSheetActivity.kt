package com.thurainx.commonui.bottom_sheet

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.thurainx.commonui.R
import kotlinx.android.synthetic.main.activity_bottom_sheet.*

class BottomSheetActivity : AppCompatActivity() {

    companion object{

        fun getIntent(context: Context) : Intent {
            return Intent(context, BottomSheetActivity::class.java)
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet)

        /* Collapsed / Expanded / Dragging / Settling / Hidden */

        val sheetBehavior = BottomSheetBehavior.from(bottomSheet)


        btnShowBottomSheet.setOnClickListener {

            if(sheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED){
                sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            }else{
                sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }

        }
    }
}