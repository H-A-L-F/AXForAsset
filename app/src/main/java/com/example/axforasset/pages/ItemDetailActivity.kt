package com.example.axforasset.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.axforasset.R
import com.example.axforasset.databinding.ActivityItemDetailBinding
import com.example.axforasset.parcel.Item

class ItemDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemDetailBinding
    private lateinit var paymentSelected: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
    }

}