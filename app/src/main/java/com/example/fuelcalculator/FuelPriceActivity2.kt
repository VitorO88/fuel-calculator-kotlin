package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class FuelPriceActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fuel_price2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //FindviewById
        //Navigate to next Screen
        val toolbar = findViewById<MaterialToolbar>(R.id.materialToolbar_fuel_price)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val edtFuelPrice = findViewById<EditText>(R.id.edtFuelPrice2)
        val btnFuelPriceNext = findViewById<Button>(R.id.btnPriceFuelCalc)

        btnFuelPriceNext.setOnClickListener {
            val edtFuelPriceValue = edtFuelPrice.text.toString().toDouble()
            val intent = Intent(this, ConsumePerLiterActivity2::class.java)
            intent.putExtra("FUEL_PRICE", edtFuelPriceValue)
            startActivity(intent)

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                finish()
                true
        }
            else -> super.onOptionsItemSelected(item)
        }

    }

}