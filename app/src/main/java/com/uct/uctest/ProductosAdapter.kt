package com.uct.uctest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductosAdapter: ListAdapter<Productos, ProductosAdapter.ProductosViewHolder>(ProductosDiffCallback()) {


    inner class ProductosViewHolder(item: View):RecyclerView.ViewHolder(item) {
        private val imageUrl = item.findViewById<ImageView>(R.id.imageUrl)
        private val title = item.findViewById<TextView>(R.id.title)

        fun bind(producto: Productos){
            title.text = producto.title
            Picasso.get().load(producto.imageURL).resize(400,400)
                .centerCrop()
                .into(imageUrl)
        }

    }

    class ProductosDiffCallback: DiffUtil.ItemCallback<Productos>() {
        override fun areItemsTheSame(oldItem: Productos, newItem: Productos): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Productos, newItem: Productos): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductosViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto, parent, false)
        return  ProductosViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductosViewHolder, position: Int) {
        val producto = getItem(position)
        holder.bind(producto)
    }

}