package com.uct.uctest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class EditarProductoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_producto)
        val db = Firebase.firestore

        val nombreProductoTxt = findViewById<EditText>(R.id.nombreProductoTxt)
        var guardarBtn = findViewById<Button>(R.id.guardarBtn)

        val productName = intent.getStringExtra("PRODUCT_NAME")
        val productoId = intent.getStringExtra("PRODUCT_ID")

        nombreProductoTxt.setText(productName.toString())

        guardarBtn.setOnClickListener {

            val producto = hashMapOf(
                "title" to nombreProductoTxt.text.toString(),
            )

            if (productoId != null) {
                db.collection("productos").document(productoId)
                    .update(producto as Map<String, Any>)
                    .addOnSuccessListener {
                        Toast.makeText( this,"Dato actualizado", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener { e -> Log.w("ERROR", "Error writing document", e) }
            }


        }


    }
}