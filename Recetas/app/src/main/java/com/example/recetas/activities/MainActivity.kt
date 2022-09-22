package com.example.recetas.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recetas.R
import com.example.recetas.adapter.IngredienteAdapter
import com.example.recetas.modelo.Ingrediente
import android.util.Log

class MainActivity : AppCompatActivity() {

    private lateinit var lstIngredientes: RecyclerView
    private lateinit var ingredientes: ArrayList<Ingrediente>
    private lateinit var botonIrRecetas: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lstIngredientes = findViewById(R.id.lstIngredientes)
        botonIrRecetas = findViewById(R.id.btnRecetas)
        setupListView()
    }

    private fun setupListView() {
        ingredientes = arrayListOf<Ingrediente>(
            Ingrediente(1, "Arroz", R.drawable.arroz, false),
            Ingrediente(2, "Cerdo", R.drawable.cerdo, false),
            Ingrediente(3, "Pollo", R.drawable.pollo, false),
            Ingrediente(4, "Tomate", R.drawable.tomate, false),
            Ingrediente(5, "Huevos", R.drawable.huevos, false),
            Ingrediente(6, "Lechuga", R.drawable.lechuga, false),
            Ingrediente(7,"Choclo", R.drawable.choclo, false),
            Ingrediente(8,"Yuca", R.drawable.yuca, false),
            Ingrediente(9,"Queso", R.drawable.queso, false),
            Ingrediente(10,"Papa", R.drawable.papa, false)
        )

        val adapter = IngredienteAdapter(ingredientes)
        lstIngredientes.layoutManager =
            GridLayoutManager(this,2)
        lstIngredientes.adapter = adapter



        botonIrRecetas.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            var ingredientesCheck : ArrayList<String> = arrayListOf()
            for(ingre in ingredientes){
                if(ingre.bandera){
                    ingredientesCheck.add(ingre.nombre)
                    Log.d("ingredientes",ingre.nombre)
                }else{
                    ingredientesCheck.remove(ingre.nombre)
                    Log.d("ingrediente eliminado",ingre.nombre)
                }
            }
            Log.d("ingredientes guardados", ingredientesCheck.size.toString())
            if(ingredientesCheck.size > 0){
                intent.putExtra("ingredientes", ingredientesCheck)
                startActivity(intent)
            }else{
                Toast.makeText(this, "tiene que seleccionar uno al menos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
