
package com.example.axforasset.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.axforasset.databinding.ActivityItemBinding

class ItemActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}