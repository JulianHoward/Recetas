package com.example.recetas.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recetas.R
import com.example.recetas.adapter.RecetaAdapter
import com.example.recetas.modelo.Ingrediente
import com.example.recetas.modelo.Receta

class MainActivity2 : AppCompatActivity(), RecetaAdapter.RecetaClickListener {

    private lateinit var lstRecetas: RecyclerView
    private lateinit var recetas: ArrayList<Receta>
    private lateinit var lstIngredientes: ArrayList<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        lstRecetas = findViewById(R.id.lstRecetas)
        lstIngredientes = intent.getSerializableExtra("ingredientes") as ArrayList<*>
        setUpListView()
    }

    private fun setUpListView() {
        recetas = arrayListOf(
            Receta(1,"Pollo al horno","Hornear pollo", arrayListOf("Pollo","Mostaza","Aceite","Tomate")),
            Receta(2,"Ostras a la muzarella","Cocer ostras y poner queso", arrayListOf("Ostras","Queso","Sal")),
            Receta(3,"Lomo borracho","Cocer con aceite", arrayListOf("Carne","Pimienta","Sal","Huevo","Arroz")),
            Receta(4,"Trucha con vino blanco","Meter al horno", arrayListOf("Vino","Pescado","Comino","Arroz"))
        )
        for(ingreSeleccionado in lstIngredientes){

            //Toast.makeText(this, ingrediente.nombre, Toast.LENGTH_SHORT).show()
            recetas = recetas.filter { receta -> receta.ingredientes.contains(ingreSeleccionado) } as ArrayList<Receta>
        }
        val adapter = RecetaAdapter(recetas,this)
        lstRecetas.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        lstRecetas.adapter = adapter
    }

    override fun onEditClick(receta: Receta) {
        val intent = Intent(this, MainActivity3::class.java)
        intent.putExtra("receta", receta)
        startActivity(intent)
    }
}
