package com.example.axforasset.pages

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.axforasset.R
import com.example.axforasset.databinding.ActivityHomeBinding
import com.example.axforasset.models.BannerModel
import com.example.axforasset.parcel.User
import com.example.axforasset.utils.BannerAdapter
import com.example.axforasset.utils.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.delay

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = intent.getParcelableExtra("user")!!

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

        viewPager2.autoScroll(
            lifecycleScope = this.lifecycleScope,
            interval = 4000L
        )
    }

    fun ViewPager2.autoScroll(lifecycleScope: LifecycleCoroutineScope, interval: Long) {
        lifecycleScope.launchWhenResumed {
            scrollIndefinitely(interval)
        }
    }

    private suspend fun ViewPager2.scrollIndefinitely(interval: Long) {
        delay(interval)
        val numberOfItems = adapter?.itemCount ?: 0
        val lastIndex = if (numberOfItems > 0) numberOfItems - 1 else 0
        val nextItem = if (currentItem == lastIndex) 0 else currentItem + 1

        setCurrentItem(nextItem, true)

        scrollIndefinitely(interval)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.profileMenu -> {
                intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("user", user)
                startActivity(intent)
            }
            R.id.itemMenu -> {
                intent = Intent(this, ItemActivity::class.java)
                intent.putExtra("user", user)
                startActivity(intent)
            }
            R.id.logoutMenu -> {
                intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("user", user)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}