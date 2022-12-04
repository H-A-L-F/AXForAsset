package com.example.axforasset.pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.axforasset.databinding.ActivityLoginBinding
import com.example.axforasset.parcel.User

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var alertDialogBuilder: AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            val uname = binding.unameEt.text.toString();
            val pass = binding.passEt.text.toString();

            if(!validateLogin(uname, pass)) return@setOnClickListener

            val user: User = User(uname, pass)

            intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
        }

    }

    private fun validateLogin(uname: String, pass: String): Boolean {
        alertDialogBuilder = AlertDialog.Builder(this)

        if(uname.isBlank() || pass.isBlank()) {
            alertDialogBuilder.setMessage("Please fill all the fields!")
                .setPositiveButton("Ok") {dialogInterface, it ->
                    dialogInterface.dismiss()
                }
                .show()
            return false
        } else if(pass.length < 8) {
            alertDialogBuilder.setMessage("Password length must be at least 8")
                .setPositiveButton("Ok") {dialogInterface, it ->
                    dialogInterface.dismiss()
                }
                .show()
            return false
        }
        return true
    }
}