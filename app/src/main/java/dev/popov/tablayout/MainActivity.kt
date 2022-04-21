package dev.popov.tablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dev.popov.tablayout.adapter.ViewPagerAdapter
import dev.popov.tablayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    private fun init() = with(binding){
        viewPager2.adapter = ViewPagerAdapter(this@MainActivity)
        TabLayoutMediator(tabLayout, viewPager2){
            tab, pos ->
            when(pos){
                0 -> {
                    tab.setIcon(R.drawable.home)
                    tab.icon?.setTint(ContextCompat.getColor(this@MainActivity, R.color.one))
                }
                1 -> {
                    tab.setIcon(R.drawable.settings)
                    tab.icon?.setTint(ContextCompat.getColor(this@MainActivity, R.color.two))
                    tab.icon?.alpha = 70
                }
                else -> {
                    tab.setIcon(R.drawable.backup)
                    tab.icon?.setTint(ContextCompat.getColor(this@MainActivity, R.color.three))
                    tab.icon?.alpha = 70
                }
        }
        }.attach()
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.icon?.alpha = 250
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.icon?.alpha = 70
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }
}