package com.example.banqumisrgraduation.ui.recyclerView

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import carbon.widget.Button
import com.example.banqumisrgraduation.R
import com.example.banqumisrgraduation.ui.CoffeBuyActivity
import java.util.*

class RvAdapterCatalog (var data: List<RvDataCatalog>) : RecyclerView.Adapter<RvAdapterCatalog.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount() = data.size

   inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val coffe = itemView.findViewById<Button>(R.id.coffe_item)
       init {
           coffe.setOnClickListener {
               val intent = Intent(itemView.context,CoffeBuyActivity::class.java)
               intent.putExtra("coffeName",data.get(adapterPosition).name)
               intent.putExtra("coffePhoto",data.get(adapterPosition).photo)
               itemView.context.startActivity(intent)

           }
       }


        fun bind(item: RvDataCatalog) = with(itemView) {
            coffe.text = item.name
            coffe.setCompoundDrawablesWithIntrinsicBounds(item.photo, 0, R.drawable.back, 0);
        }
    }
}