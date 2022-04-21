package dev.popov.tablayout.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import dev.popov.tablayout.screens.FirstFragment
import dev.popov.tablayout.screens.SecondFragment
import dev.popov.tablayout.screens.ThirdFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> FirstFragment()
            1 -> SecondFragment()
            else -> {
                ThirdFragment()
            }
        }
    }
}