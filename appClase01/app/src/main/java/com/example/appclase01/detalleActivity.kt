package com.example.appclase01

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalle.*

class detalleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        //Recuperar el bandle
        val bundle=intent.extras
        //validar el esquema (si no esta vacio)
        bundle?.let {
            val nombres=bundle.getString("KEY_NOMBRES") ?: "Desconocido"
            val edad=bundle.getString("KEY_EDAD") ?: "Desconocido"
            val genero=bundle.getString("KEY_GENERO") ?: "Desconocido"

            txtNombresDetalle.text=nombres;
            txtEdadDetalle.text=edad;
            txtGeneroDetalle.text=genero;
        }
    }


}