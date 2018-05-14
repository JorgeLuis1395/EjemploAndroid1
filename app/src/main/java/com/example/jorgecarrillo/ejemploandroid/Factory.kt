package com.example.jorgecarrillo.ejemploandroid

class Factory {
    companion object {
        var usuarios:ArrayList<Usuario> = ArrayList()

        init {
            usuarios.add(Usuario("Adrian", "Eguez", "Azul"))
            usuarios.add(Usuario("Vicente", "Sarzosa", "Cafe"))
            usuarios.add(Usuario("Wendy", "Eguez", "Blanco"))
        }

    }
}