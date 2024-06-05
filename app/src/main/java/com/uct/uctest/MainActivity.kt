package com.uct.uctest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

/**
 * Lista de tareas
 * Lista de compras
 * Pokedex
 * Ecommerce (listar productos)
 * App de restaurante (listar restaurantes)
 *
 * */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Firebase.firestore

        var usuario: EditText = findViewById(R.id.edtUser)
        var password = findViewById<EditText>(R.id.edtPass)
        var boton: Button = findViewById(R.id.btnLogin)
        var bienvenida:TextView = findViewById(R.id.txtBievenida)

        bienvenida.setOnClickListener {
            bienvenida.text = "Bienvenido " + usuario.text.toString()
        }

        boton.setOnClickListener {
            //https://firebase.google.com/docs/firestore/quickstart?hl=es-419#kotlin+ktx
            val user = hashMapOf(
                "usuario" to usuario.text.toString(),
                "password" to password.text.toString()
            )

            db.collection("usuarios")
                .add(user)

            if(usuario.text.toString() == "gian" && password.text.toString() == "123"){
                Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
                var intent = Intent(this,CalculadoraActivity::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
            }
        }

    }
}