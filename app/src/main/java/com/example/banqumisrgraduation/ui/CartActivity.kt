package com.example.banqumisrgraduation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.banqumisrgraduation.R
import com.example.banqumisrgraduation.ui.recyclerView.CartAdapter
import com.example.banqumisrgraduation.ui.recyclerView.OnCountButtonClickListener
import com.example.banqumisrgraduation.ui.recyclerView.RvDataCart
import kotlin.properties.Delegates

class CartActivity : AppCompatActivity(), OnCountButtonClickListener {
    private var totalPrice: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val items = mutableListOf(
            RvDataCart(R.drawable.cappuccino, "Cappuccino", 15, 1),
            RvDataCart(R.drawable.espresso, "Espresso", 20, 3),
        )
        val recyclerView: RecyclerView = findViewById(R.id.cart_items_rv)
        val adapter = CartAdapter(items, this)
        recyclerView.adapter = adapter

        totalPrice = items.sumOf { it.itemPrice * it.itemCount }
        val totalPriceTextView: TextView = findViewById(R.id.total_price_tv)
        totalPriceTextView.text = "$$totalPrice"
    }

    fun onBack(view: View) {
        onBackPressed()
    }

    override fun clickAction(amount: Int) {
        totalPrice += amount
        val totalPriceTextView: TextView = findViewById(R.id.total_price_tv)
        totalPriceTextView.text = "$$totalPrice"
    }
}