package com.uct.uctest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // LA UCT ES LO MAXIMO!!

        var usuario: EditText = findViewById(R.id.edtUser)
        var password = findViewById<EditText>(R.id.edtPass)
        var boton: Button = findViewById(R.id.btnLogin)
        var bienvenida:TextView = findViewById(R.id.txtBievenida)

        bienvenida.setOnClickListener {
            bienvenida.text = "Bienvenido " + usuario.text.toString()
            //OTRA LOGICA ADICIONAL
        }

        boton.setOnClickListener {

            if(usuario.text.toString() == "gian" && password.text.toString() == "123"){
                Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
                var intent = Intent(this,CalculadoraActivity::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
            }
        }

    }
}