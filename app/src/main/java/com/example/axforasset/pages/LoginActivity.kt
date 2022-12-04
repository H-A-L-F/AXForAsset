package com.example.axforasset.pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.axforasset.databinding.ActivityLoginBinding
import com.example.axforasset.parcel.User

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            val uname = binding.unameEt.text.toString()
            val pass = binding.passEt.text.toString()

            val User = User(uname, pass)

            intent = Intent(this, )
        }

    }
}