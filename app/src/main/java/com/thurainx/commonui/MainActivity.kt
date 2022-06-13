package com.thurainx.commonui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thurainx.commonui.bottom_appbar.BottomAppBarActivity
import com.thurainx.commonui.bottom_navigation.BottomNavigationActivity
import com.thurainx.commonui.bottom_navigation_with_viewpager.BottomNavigationWithViewPagerActivity
import com.thurainx.commonui.bottom_sheet.BottomSheetActivity
import com.thurainx.commonui.collapsing_tool_bar.CollapsingToolBarActivity
import com.thurainx.commonui.constraint_layout.ConstraintLayoutActivity
import com.thurainx.commonui.coordinator_layout.CoordinatorLayoutActivity
import com.thurainx.commonui.drawer_layout.DrawerLayoutActivity
import com.thurainx.commonui.material_components.MaterialComponentsActivity
import com.thurainx.commonui.recycler_view.RecyclerViewActivity
import com.thurainx.commonui.services_test.ServiceActivity
import com.thurainx.commonui.viewpager_with_custom_adapter.ViewPagerCustomAdapterActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnNavigationActivity.setOnClickListener {
            val intent = BottomNavigationActivity.getIntent(this)
            startActivity(intent)
        }

        btnNavigationWithPagerActivity.setOnClickListener {
            val intent = BottomNavigationWithViewPagerActivity.getIntent(this)
            startActivity(intent)
        }

        btnBottomAppBar.setOnClickListener {
            val intent = BottomAppBarActivity.getIntent(this)
            startActivity(intent)
        }

        btnBottomSheet.setOnClickListener {
            val intent = BottomSheetActivity.getIntent(this)
            startActivity(intent)
        }

        btnMaterialComponents.setOnClickListener {
            val intent = MaterialComponentsActivity.getIntent(this)
            startActivity(intent)
        }

        btnCollapsingToolBar.setOnClickListener {
            val intent = CollapsingToolBarActivity.getIntent(this)
            startActivity(intent)
        }

        btnCoordinatorLayout.setOnClickListener {
            val intent = CoordinatorLayoutActivity.getIntent(this)
            startActivity(intent)
        }

        btnDrawerLayout.setOnClickListener {
            val intent = DrawerLayoutActivity.getIntent(this)
            startActivity(intent)
        }

        btnConstraintLayout.setOnClickListener {
            val intent = ConstraintLayoutActivity.getIntent(this)
            startActivity(intent)
        }

        btnRecyclerView.setOnClickListener {
            val intent = RecyclerViewActivity.getIntent(this)
            startActivity(intent)
        }

        btnViewPagerWithCustomAdapter.setOnClickListener {
            val intent = ViewPagerCustomAdapterActivity.getIntent(this)
            startActivity(intent)
        }

        btnService.setOnClickListener {
            val intent = ServiceActivity.getIntent(this)
            startActivity(intent)
        }


    }
}