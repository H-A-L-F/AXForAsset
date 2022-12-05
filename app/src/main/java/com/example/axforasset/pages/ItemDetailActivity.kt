package com.example.axforasset.pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import com.example.axforasset.R
import com.example.axforasset.databinding.ActivityItemDetailBinding
import com.example.axforasset.parcel.Item
import com.example.axforasset.parcel.User

class ItemDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemDetailBinding
    private lateinit var paymentSelected: String
    private lateinit var alertDialogBuilder: AlertDialog.Builder
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = intent.getParcelableExtra("user")!!

        val item: Item = intent.getParcelableExtra("item")!!

        binding.apply {
            itemImg.setImageResource(item.image)
        }

        val spinner = binding.paymentSp
        val adapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this, R.array.payments, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                paymentSelected = parent?.getItemAtPosition(position).toString()
            }

        }

        binding.purchaseBtn.setOnClickListener {
            val email = binding.emailEt.text.toString()
            alertDialogBuilder = AlertDialog.Builder(this)

            when {
                email.isBlank() -> alertDialogBuilder.setMessage("Please fill in your email")
                    .setPositiveButton("Ok") {dialogInterface, it ->
                        dialogInterface.dismiss()
                    }
                    .show()
                paymentSelected.isBlank() -> alertDialogBuilder.setMessage("You must pick a payment method")
                    .setPositiveButton("Ok") {dialogInterface, it ->
                        dialogInterface.dismiss()
                    }
                    .show()
                else -> {
                    intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("user", user)
                    startActivity(intent)
                }
            }
        }
    }

}