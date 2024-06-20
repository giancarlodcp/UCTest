package com.uct.uctest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ListadoProductos : AppCompatActivity(), ProductosAdapter.ProductosClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_productos)

        var recycler: RecyclerView = findViewById(R.id.recycler)

        val adapter = ProductosAdapter(this)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        val list = mutableListOf(
            Productos("", "","Television", 10.0),
            Productos("", "","Tablets", 10.0),
            Productos("", "","Laptop", 10.0)
        )

        val db = Firebase.firestore
        db.collection("productos")
            //.whereEqualTo("name", "Laptop")
            .addSnapshotListener { value, e ->
                if (e != null) {
                    Log.w("LIST_FIREBASE", "Listen failed.", e)
                    return@addSnapshotListener
                }

                val listProductos = ArrayList<Productos>()
                for (doc in value!!) {
                    val producto = Productos("","","",0.0)
                    doc.getString("id")?.let { producto.id = it }
                    doc.getString("imageUrl")?.let { producto.imageURL = it }
                    doc.getDouble("price")?.let { producto.price = it }
                    doc.getString("title")?.let { producto.title = it }
                    listProductos.add(producto)
                }

                Log.d("LIST_FIREBASE", "Current products: $listProductos")
                adapter.submitList(listProductos)

            }
    }

    override fun onProductClick(producto: Productos) {
        val intent = Intent(this, EditarProductoActivity::class.java)
        intent.putExtra("PRODUCT_ID", producto.id)
        intent.putExtra("PRODUCT_NAME", producto.title)
        startActivity(intent)
    }

}