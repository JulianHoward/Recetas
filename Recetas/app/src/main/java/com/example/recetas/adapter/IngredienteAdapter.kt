package com.example.recetas.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recetas.R
import com.example.recetas.modelo.Ingrediente

class IngredienteAdapter(
    var objects: ArrayList<Ingrediente>
) :
    RecyclerView.Adapter<IngredienteAdapter.IngredienteViewHolder>() {

    class IngredienteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ingName: TextView
        val ingImage: ImageView

        init {
            ingName = itemView.findViewById(R.id.txtIngrediente)
            ingImage = itemView.findViewById(R.id.imgIngrediente)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredienteViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.ingrediente_item_layout,parent,false)
        return IngredienteViewHolder(view)
    }

    override fun onBindViewHolder(holder: IngredienteViewHolder, position: Int) {
        val ingrediente = objects[position]
        //holder.ingName.text = ingrediente.nombre
        holder.ingImage.setImageResource(ingrediente.img)
        holder.ingImage.setOnClickListener {
            ingrediente.bandera =  !ingrediente.bandera
            if(ingrediente.bandera){
                holder.ingImage.setBackgroundColor(Color.BLUE)
            }else{
                holder.ingImage.setBackgroundColor(Color.WHITE)
            }
        }
    }

    override fun getItemCount(): Int {
        return objects.size
    }
}
