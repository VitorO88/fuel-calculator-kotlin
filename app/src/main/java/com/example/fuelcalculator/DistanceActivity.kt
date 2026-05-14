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

class DistanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distance)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<MaterialToolbar>(R.id.materialToolbar_distance)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val fuelPrice = intent.getDoubleExtra("PRICE_LITER", 0.0)
        val consumePerLiter = intent.getIntExtra("CONSUME_PER_LITER",0)

        val edtDistance = findViewById<EditText>(R.id.edtDistance2)
        val btnDistanceCalc = findViewById<Button>(R.id.btnDistanceCal)

        btnDistanceCalc.setOnClickListener {

            val distance = edtDistance.text.toString().toInt()
            val consume: Int = consumePerLiter
            val fuelPrice = fuelPrice

        //Calc liter required
        val litersRequired = distance / consume
        // Calc Total Cost
        val totalCost = litersRequired * fuelPrice

        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("DISTANCE_LITERS_PRICE", fuelPrice )
        intent.putExtra("DISTANCE_LITERS_CONSUME", consume)
        intent.putExtra("DISTANCE_VALUE", distance)
        intent.putExtra("DISTANCE_TOTAL_COST", totalCost)

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