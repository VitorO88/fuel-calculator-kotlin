package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val totalCost = intent.getDoubleExtra("DISTANCE_TOTAL_COST", 0.0)
        val pricePerLiter = intent.getDoubleExtra("DISTANCE_LITERS_PRICE",0.0)
        val consumePerLiter = intent.getIntExtra("DISTANCE_LITERS_CONSUME", 0)
        val distanceTotal = intent.getIntExtra("DISTANCE_VALUE", 0)

        val tvTravelCost = findViewById<TextView>(R.id.tvTravelCost)
        val tvLiterPrice = findViewById<TextView>(R.id.tvResultPrice)
        val tvConsumeLiter = findViewById<TextView>(R.id.tvResultConsume)
        val tvDistance = findViewById<TextView>(R.id.tvResultDistance)
        val btnResultNew = findViewById<Button>(R.id.btnResultNew)

        tvTravelCost.text = String.format(Locale.GERMANY, "€ %.2f", totalCost)
        tvLiterPrice.text = String.format(Locale.GERMANY, "€ %.2f", pricePerLiter)
        tvConsumeLiter.text = "$consumePerLiter L"
        tvDistance.text = "$distanceTotal Km"

        btnResultNew.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}