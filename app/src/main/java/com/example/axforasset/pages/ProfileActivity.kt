package com.example.axforasset.pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.axforasset.R
import com.example.axforasset.databinding.ActivityProfileBinding
import com.example.axforasset.parcel.User

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = intent.getParcelableExtra("user")!!

        binding.apply {
            ("Hi, " + user.username).also { unameTitleTv.text = it }
            (user.username + "@gmail.com").also { emailTv.text = it }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.profile_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.itemMenu -> {
                intent = Intent(this, ItemActivity::class.java)
                intent.putExtra("user", user)
                startActivity(intent)
            }
            R.id.homeMenu -> {
                intent = Intent(this, HomeActivity::class.java)
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