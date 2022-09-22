package com.example.recetas.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.recetas.R
import com.example.recetas.modelo.Receta

class MainActivity3 : AppCompatActivity() {

    private lateinit var nombre: TextView
    private lateinit var ingredientes: TextView
    private lateinit var preparacion: TextView
    private lateinit var comida: Receta


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        nombre = findViewById(R.id.txtRecetaNombre)
        ingredientes = findViewById(R.id.txtIngredientes)
        preparacion = findViewById(R.id.txtPreparacion)
        setUpListView()
    }

    private fun setUpListView() {
        comida = intent.getSerializableExtra("receta") as Receta

        nombre.text = comida.nombre
        ingredientes.text = comida.ingredientes.toString()
        preparacion.text = comida.preparacion
    }
}
