package com.example.recetas.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recetas.R
import com.example.recetas.modelo.Receta

class RecetarioAdapter(
    var objects: ArrayList<Receta>
) :
    RecyclerView.Adapter<RecetarioAdapter.RecetarioViewHolder>() {
    class RecetarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreRecetario: TextView
        val ingredientesRecetario: TextView
        val preparacionRecetario: TextView

        init {
            nombreRecetario = itemView.findViewById(R.id.txtRecetaNombre)
            ingredientesRecetario = itemView.findViewById(R.id.txtIngredientes)
            preparacionRecetario = itemView.findViewById(R.id.txtPreparacion)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetarioViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecetarioViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}