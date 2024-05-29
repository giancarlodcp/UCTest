package com.uct.uctest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        var number1: EditText = findViewById(R.id.number1)
        var number2: EditText = findViewById(R.id.number2)
        var btnSuma:Button = findViewById(R.id.btnSuma)
        var txtAnswer:TextView = findViewById(R.id.txtAnswer)

        btnSuma.setOnClickListener {
            var respuesta = number1.text.toString().toDouble() + number2.text.toString().toDouble()
            txtAnswer.setText("Respuesta: " + respuesta)
        }



    }
}