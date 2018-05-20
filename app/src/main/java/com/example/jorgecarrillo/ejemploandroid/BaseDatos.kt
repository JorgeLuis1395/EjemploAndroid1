package com.example.jorgecarrillo.ejemploandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class BaseDatos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_datos)
        val dbHandler = DbHandlerAplicacion(this)
        dbHandler.insertarUsuario("Jorge")
        dbHandler.leerDatos()
    }

}
