package com.example.banqumisrgraduation.ui.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.banqumisrgraduation.R

interface OnCountButtonClickListener {
    fun clickAction(amount: Int)
}

class CartAdapter(
    private val items: MutableList<RvDataCart>,
    private val onCountButtonClick: OnCountButtonClickListener
) :
    RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemImageView: ImageView
        val itemNameTextView: TextView
        val itemPriceTextView: TextView
        val itemCountTextView: TextView

        init {
            itemImageView = view.findViewById(R.id.cart_item_iv)
            itemNameTextView = view.findViewById(R.id.cart_item_name_tv)
            itemPriceTextView = view.findViewById(R.id.cart_item_price_tv)
            itemCountTextView = view.findViewById(R.id.cart_item_count_tv)
            val decreaseCountImageButton: ImageButton =
                view.findViewById(R.id.cart_decrease_count_ib)
            decreaseCountImageButton.setOnClickListener {
                val itemPrice = items[adapterPosition].itemPrice
                onCountButtonClick.clickAction(-itemPrice)
                val textCount = itemCountTextView.text.toString().toInt()
                if (textCount == 1) {
                    items.removeAt(adapterPosition)
                    notifyItemRemoved(adapterPosition)
                    return@setOnClickListener
                }
                itemCountTextView.text = (textCount - 1).toString()
            }
            val increaseCountImageButton: ImageButton =
                view.findViewById(R.id.cart_increase_count_ib)
            increaseCountImageButton.setOnClickListener {
                val textCount = itemCountTextView.text.toString().toInt()
                if (textCount == ITEM_COUNT_LIMIT) {
                    Toast.makeText(itemView.context, "Item order limit reached", Toast.LENGTH_SHORT)
                        .show()
                    return@setOnClickListener
                }
                itemCountTextView.text = (textCount + 1).toString()
                val itemPrice = items[adapterPosition].itemPrice
                onCountButtonClick.clickAction(itemPrice)
            }
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cart_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        //TODO: Replace to handle loading image from API response
        val currentItem = items[position]
        viewHolder.itemImageView.setImageResource(currentItem.itemImage)
        viewHolder.itemNameTextView.text = currentItem.itemName
        viewHolder.itemPriceTextView.text = "$${currentItem.itemPrice}"
        viewHolder.itemCountTextView.text = currentItem.itemCount.toString()
    }

    override fun getItemCount() = items.size

    private companion object {
        private const val ITEM_COUNT_LIMIT = 10
    }

}
