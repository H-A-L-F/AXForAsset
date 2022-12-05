package com.example.axforasset.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.axforasset.R
import com.example.axforasset.databinding.ActivityHomeBinding
import com.example.axforasset.models.BannerModel
import com.example.axforasset.parcel.User
import com.example.axforasset.utils.BannerAdapter
import com.example.axforasset.utils.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user: User = intent.getParcelableExtra("user")!!

        supportActionBar?.title = "Hi, " + user.username

        val bannerList = ArrayList<BannerModel>()
        bannerList.add(BannerModel(R.drawable.banner1))
        bannerList.add(BannerModel(R.drawable.banner2))
        bannerList.add(BannerModel(R.drawable.banner3))

        val adapter = BannerAdapter(bannerList)

        binding.carouselRecyclerview.adapter = adapter
        binding.carouselRecyclerview.apply {
            set3DItem(true)
            setAlpha(true)
            setInfinite(true)
        }

        val tabLayout = binding.tncTl
        val viewPager2 = binding.tncVp

        val vpAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        viewPager2?.adapter = vpAdapter
        TabLayoutMediator(tabLayout!!, viewPager2!!) { tab, position ->
            when(position) {
                0 -> {
                    tab.text = "Terms"
                }
                1 -> {
                    tab.text = "Conditions"
                }
            }
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return super.onContextItemSelected(item)
    }
}