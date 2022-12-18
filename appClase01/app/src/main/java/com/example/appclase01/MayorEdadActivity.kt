package com.example.appclase01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_generaciones.*
import kotlinx.android.synthetic.main.activity_mayor_edad.*

class MayorEdadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mayor_edad)
        this.procesar()
    }

    fun procesar() {
        btnProcesar.setOnClickListener {
            val edad = editEdad.text.toString().toInt()
            when (edad) {
                in 0..17 -> {
                    txtMayorEdad.setText("Eres menor de edad")
                }
                in 18..64 -> {
                    txtMayorEdad.setText("Eres mayor de edad")
                }
                else -> {
                    txtMayorEdad.setText("Tu edad no es valida")
                }
            }
        }

    }
}