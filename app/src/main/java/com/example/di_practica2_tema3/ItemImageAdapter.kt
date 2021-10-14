package com.example.di_practica2_tema3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ItemImageAdapter(var items: ArrayList<ItemImage>) : RecyclerView.Adapter<ItemImageAdapter.TarjViewHolder>() {
    lateinit var onClick : (View) -> Unit


    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var imagen: ImageView

        init {
            imagen = itemView.findViewById(R.id.ivImage)
        }

        fun bindTarjeta(item: ItemImage, onClick: (View) -> Unit) = with(itemView) {
            imagen.setImageResource(item.image)
            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_image, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val item = items.get(pos)
        viewHolder.bindTarjeta(item, onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

