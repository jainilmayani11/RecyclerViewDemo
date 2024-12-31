package com.example.recyclerviewdemo

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ContactDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact_details)

        val contactImage: ImageView = findViewById(R.id.contactDetailImage)
        val contactName: TextView = findViewById(R.id.contactDetailName)
        val contactNumber: TextView = findViewById(R.id.contactDetailNumber)

        // Retrieve the data
        val img = intent.getIntExtra("image", R.drawable.ic_launcher_foreground)
        val name = intent.getStringExtra("name") ?: "Unknown"
        val number = intent.getIntExtra("number", 0)

        // Set data to views
        contactImage.setImageResource(img)
        contactName.text = name
        contactNumber.text = number.toString()

    }
}