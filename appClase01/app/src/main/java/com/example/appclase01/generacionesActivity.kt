package com.example.appclase01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_generaciones.*

class generacionesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generaciones)
        this.validar()
    }

    fun validar() {
        btnVerificar.setOnClickListener {
            val anio = editAnio.text.toString().toInt()
            when (anio) {
                in 1930..1948 -> {
                    txtGeneracion.setText("GENERACION SILENT GENERATION. Poblacion: 6.300.000. Caracteristica: Austeridad")
                }
                in 1949..1968 -> {
                    txtGeneracion.setText("GENERACION BABY BOOM. Poblacion: 12.200.000. Caracteristica: Ambición")
                }
                in 1969..1980 -> {
                    txtGeneracion.setText("GENERACION X. Poblacion: 9.300.000. Caracteristica: Obsesión por el éxito")
                }
                in 1981..1993 -> {
                    txtGeneracion.setText("GENERACION Y. Poblacion: 7.200.000. Caracteristica: Frustración")
                }
                in 1994..2010 -> {
                    txtGeneracion.setText("GENERACION Z. Poblacion: 7.800.000. Caracteristica: Irreverencia")
                }
                else -> {
                    txtGeneracion.setText("NINGUNA GENERACION")
                }
            }
        }
    }
}