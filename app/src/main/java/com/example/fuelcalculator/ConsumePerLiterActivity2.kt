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

class ConsumePerLiterActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consume_per_liter2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //recover data from previous screen
        val toolbar = findViewById<MaterialToolbar>(R.id.materialToolbar_consume_per_liter)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

         val fuelPrice = intent.getDoubleExtra("FUEL_PRICE", 0.0)
         val edtConsumePerLiter = findViewById<EditText>(R.id.edtConsumeLiter2)
         val btnConsumePerLiterNext = findViewById<Button>(R.id.btnConsumeNext)
         
        btnConsumePerLiterNext.setOnClickListener {
            val consumePerLiterValue = edtConsumePerLiter.text.toString().toInt()
            val intent = Intent(this, DistanceActivity::class.java )
            intent.putExtra("CONSUME_PER_LITER", consumePerLiterValue)
            intent.putExtra("PRICE_LITER", fuelPrice)
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