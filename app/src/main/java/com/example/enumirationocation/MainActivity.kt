package com.example.enumirationocation

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerCars: Spinner
    private lateinit var edtDays: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvDetails: TextView
    private lateinit var tvDays: TextView
    private lateinit var tvPricePerDay: TextView
    private lateinit var tvTotalPrice: TextView

    private lateinit var locationManager: LocationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerCars = findViewById(R.id.spinnerCars)
        edtDays = findViewById(R.id.edtDays)
        btnCalculate = findViewById(R.id.btnCalculate)
        tvDetails = findViewById(R.id.tvDetails)
        tvDays = findViewById(R.id.tvDays)
        tvPricePerDay = findViewById(R.id.tvPricePerDay)
        tvTotalPrice = findViewById(R.id.tvTotalPrice)

        locationManager = LocationManager()

        val carTypes = resources.getStringArray(R.array.car_types)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, carTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCars.adapter = adapter

        spinnerCars.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>, view: View?, position: Int, id: Long) {
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {}
        }

        btnCalculate.setOnClickListener {
            val selectedCarType = spinnerCars.selectedItem.toString()
            val jours = edtDays.text.toString().toIntOrNull()

            if (jours == null || jours <= 0) {
                Toast.makeText(this, "Please enter a valid number of days", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val typeVoiture = TypeVoiture.valueOf(selectedCarType)

            val rentalDetails = locationManager.calculateRentalDetails(typeVoiture, jours)

            tvDetails.text = "Rental Details"
            tvDays.text = "Nombre de jours: $jours"
            tvPricePerDay.text = "Prix par jour: ${typeVoiture.prix} MAD"
            tvTotalPrice.text = rentalDetails
        }
    }
}
