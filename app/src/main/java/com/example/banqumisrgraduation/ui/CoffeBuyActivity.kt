package com.example.banqumisrgraduation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.banqumisrgraduation.R

class CoffeBuyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coffe_buy)
        val photo = findViewById<ImageView>(R.id.coffe_photo)
        val nameCoffe = findViewById<TextView>(R.id.coffe_name)
        val namePrice = findViewById<TextView>(R.id.name_price)
        val coffePhoto = intent.getIntExtra("coffePhoto",0)
        val coffeName = intent.getStringExtra("coffeName")
        nameCoffe.text =coffeName
        namePrice.text =coffeName
        photo.setImageResource(coffePhoto)
    }

    fun onBack(view: View) {
        onBackPressed()
    }
}