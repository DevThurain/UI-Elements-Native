package com.thurainx.commonui.recycler_view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.thurainx.commonui.R
import com.thurainx.commonui.collapsing_tool_bar.CollapsingToolBarActivity
import com.thurainx.commonui.material_components.MaterialComponentsActivity
import com.thurainx.commonui.recycler_view.adapter.PostAdapter
import com.thurainx.commonui.recycler_view.delegate.PostItemDelegate
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity(),PostItemDelegate {
    companion object{
        fun getIntent(context: Context) : Intent {
            return Intent(context, RecyclerViewActivity::class.java)
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val postAdapter = PostAdapter(this)
        rvPost.adapter = postAdapter
        rvPost.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }

    override fun onTap() {
        startActivity(CollapsingToolBarActivity.getIntent(this))
    }


}