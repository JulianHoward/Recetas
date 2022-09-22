package com.example.recetas.modelo

import android.widget.ImageView
import java.io.Serializable

class Ingrediente(
    var id: Int,
    var nombre: String,
    var img: Int,
    var bandera: Boolean
) : Serializable {
    override fun toString(): String {
        return "$nombre"
    }
}
