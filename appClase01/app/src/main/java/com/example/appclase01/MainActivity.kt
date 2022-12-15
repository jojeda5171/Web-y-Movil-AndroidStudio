package com.example.appclase01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.confirmarDatos()
    }
    //Opcion 1 --> usando findViewById
    //Opcion 2 --> plugin extensions
    //Opcion 3 --> ViewBinding

    fun confirmarDatos() {
        btnConfirmar.setOnClickListener {
            val nombre = editNombres.text.toString()
            val apellido = editApellidos.text.toString()
            val resultado = "Bienvenido: $nombre $apellido"
            txtResultado.setText(resultado)
        }
    }
}