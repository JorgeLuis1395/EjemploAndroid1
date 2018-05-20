package com.example.jorgecarrillo.ejemploandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_escritura_archivos.*
import java.io.FileWriter
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_crear_usuario.*


class escrituraArchivos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escritura_archivos)

        buttonGuardar.setOnClickListener { v: View? -> escrituraaArchivo("Nombre ${editText2.text.toString()} Apellido ${editText2.text.toString()} edad ${editText4.text.toString()}")

            val toast1 = Toast.makeText(applicationContext, " Se Guardo", Toast.LENGTH_SHORT)
            toast1.setGravity(Gravity.CENTER, 0, 0)
            toast1.show() }

    }
    fun escrituraaArchivo (str: String){
        try {
             val guardar= FileWriter("Archivo.txt", true)
            guardar.write(str)
             guardar.close()
        }catch (ex:Exception){
            print(ex.message)
            }
    }


}
