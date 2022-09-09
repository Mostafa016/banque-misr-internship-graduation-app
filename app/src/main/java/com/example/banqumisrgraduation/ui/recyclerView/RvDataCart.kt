package com.example.banqumisrgraduation.ui.recyclerView

//TODO: Change itemPhoto type to handle loading image from API response
data class RvDataCart(
    val itemImage: Int,
    val itemName: String,
    val itemPrice: Int,
    val itemCount: Int,
)