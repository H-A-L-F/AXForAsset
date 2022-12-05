package com.example.axforasset.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.axforasset.fragments.ConditionsFragment
import com.example.axforasset.fragments.TermsFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> {
                TermsFragment()
            }
            1 -> {
                ConditionsFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}