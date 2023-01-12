package com.example.appclase01

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_mayor_edad.*
import kotlinx.android.synthetic.main.activity_registrar.*

class RegistrarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)
        this.enviarDatos();
    }

    fun enviarDatos(){
        btnEnviarRegistro.setOnClickListener {
            val nombres=editNombresRegistro.text.toString();
            val edad=editEdadRegistro.text.toString();
            val genero=if(rvFemenino.isChecked) rvFemenino.text.toString()
            else rvMasculino.text.toString()

            if(nombres.isEmpty()){
                Toast.makeText(this, "Ingrese los nombres", Toast.LENGTH_LONG).show();
            }

            if(edad.isEmpty()){
                Toast.makeText(this, "Ingrese la edad", Toast.LENGTH_LONG).show();
            }

            if(!cvTerminos.isChecked){
                Toast.makeText(this, "Acepte los Terminos", Toast.LENGTH_SHORT).show();
            }

            val bundle=Bundle().apply {
                putString("KEY_NOMBRES", nombres)
                putString("KEY_EDAD", edad)
                putString("KEY_GENERO", genero)
            }

            val intent=Intent(this, detalleActivity::class.java).putExtras(bundle);
            startActivity(intent);
        }
    }
}