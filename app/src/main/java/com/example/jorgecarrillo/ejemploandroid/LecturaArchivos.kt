package com.example.jorgecarrillo.ejemploandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_lectura_archivos.*
import java.io.BufferedReader
import java.io.InputStreamReader


class LecturaArchivos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lectura_archivos)
        lecturaArchivos()
    }
    fun lecturaArchivos(){
        try {
            val fin = BufferedReader(
                    InputStreamReader(
                            openFileInput("prueba_int.txt")))

            textViewLecturaArchivos.text = fin.readLine()
            fin.close()
        } catch (ex: Exception) {
            Log.e("Ficheros", "Error al leer fichero desde memoria interna")
        }

    }
}
