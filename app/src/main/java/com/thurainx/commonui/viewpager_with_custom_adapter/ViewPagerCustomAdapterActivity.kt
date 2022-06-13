package com.thurainx.commonui.viewpager_with_custom_adapter

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thurainx.commonui.R
import com.thurainx.commonui.recycler_view.RecyclerViewActivity
import com.thurainx.commonui.viewpager_with_custom_adapter.adapter.ImageAdapter
import kotlinx.android.synthetic.main.activity_view_pager_custom_adapter.*

class ViewPagerCustomAdapterActivity : AppCompatActivity() {

    companion object{
        fun getIntent(context: Context) : Intent {
            return Intent(context, ViewPagerCustomAdapterActivity::class.java)
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager_custom_adapter)

        val imageAdapter = ImageAdapter()
        vpCustomAdapter.adapter = imageAdapter
    }
}