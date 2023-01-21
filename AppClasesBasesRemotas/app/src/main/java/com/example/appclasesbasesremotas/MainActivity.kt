package com.example.appclasesbasesremotas

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.appclasesbasesremotas.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        leerDatos()
        leerDatosList()
    }

    fun leerDatos() {
        val url = "https://jsonplaceholder.typicode.com/posts/1"
        val sentencia = Volley.newRequestQueue(this)
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            { response ->
                binding.edtUserId.setText(response.getString("userId"))
                binding.edtTitle.setText(response.getString("title"))
                binding.edtVal.setText(response.getString("body"))
            },
            { error ->

            }
        )
        sentencia.add(jsonObjectRequest)
    }

    fun leerDatosList() {
        val url = "https://jsonplaceholder.typicode.com/posts"
        val sentencia = Volley.newRequestQueue(this)
        val jsonObjectRequest = JsonArrayRequest(
            Request.Method.GET,
            url,
            null,
            { response ->
                val posts= ArrayList<String>()
                for(i in 0 until   response.length()){
                    posts.add(response.getJSONObject(i)["body"].toString())

                }
                val adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,posts)
                val list=binding.lista
                list.adapter=adapter
            },
            { error ->
            }
        )
        sentencia.add(jsonObjectRequest)
    }
}