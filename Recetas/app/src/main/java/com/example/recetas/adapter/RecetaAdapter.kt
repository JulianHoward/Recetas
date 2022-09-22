package com.example.recetas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recetas.R
import com.example.recetas.modelo.Receta

class RecetaAdapter(
    var objects: ArrayList<Receta>,
    val listener: RecetaClickListener
) :
    RecyclerView.Adapter<RecetaAdapter.RecetaViewHolder>() {

    class RecetaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val recetaName: TextView
        val recetaBoton: Button

        init {
            recetaName = itemView.findViewById(R.id.txtRecetaName)
            recetaBoton = itemView.findViewById(R.id.btnGo)
        }
    }

    interface RecetaClickListener{
        fun onEditClick(receta: Receta)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetaViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.receta_item_activity,parent,false)
        return RecetaViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecetaViewHolder, position: Int) {
        val receta = objects[position]
        holder.recetaName.text = receta.nombre
        holder.recetaBoton.setOnClickListener { listener.onEditClick(receta) }
    }

    override fun getItemCount(): Int {
        return objects.size
    }
}
