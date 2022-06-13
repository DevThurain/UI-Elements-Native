package com.thurainx.commonui.bottom_navigation_with_viewpager.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.thurainx.commonui.fragments.HomeFragment
import com.thurainx.commonui.fragments.NotificationFragment
import com.thurainx.commonui.fragments.SettingFragment

class BottomNavigationViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> HomeFragment()
            1 -> NotificationFragment()
            2 -> SettingFragment()
            else -> HomeFragment()
        }
    }
}