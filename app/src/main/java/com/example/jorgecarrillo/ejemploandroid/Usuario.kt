package com.example.jorgecarrillo.ejemploandroid

class Usuario constructor(var nombre: String,
                          var apellido: String,
                          var colorFavorito: String) {

    override fun toString(): String {
        return "$nombre $apellido"
    }
}