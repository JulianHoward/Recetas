package com.example.recetas.modelo

import java.io.Serializable

class Receta(
    var id: Int,
    var nombre: String,
    var preparacion: String,
    var ingredientes: ArrayList<String>
) : Serializable {
    override fun toString(): String {
        return "$nombre"
    }
}
