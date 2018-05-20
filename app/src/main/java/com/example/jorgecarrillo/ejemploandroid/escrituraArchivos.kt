package com.example.jorgecarrillo.ejemploandroid

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_escritura_archivos.*
import android.view.Gravity
import android.widget.Toast
import java.io.OutputStreamWriter


class escrituraArchivos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escritura_archivos)

        buttonGuardar.setOnClickListener { escrituraaArchivo("Nombre ${editText2.text.toString()} Apellido ${editText4.text.toString()} edad ${editText3.text.toString()} $/n ")

          }

    }
    fun escrituraaArchivo (texto : String) {
        /*try {
             val guardar= FileWriter("Archivo.txt", true)
            guardar.write(str)
             guardar.close()
        }catch (ex:Exception){
            print(ex.message)
            }*/
        try {
            val fout = OutputStreamWriter(
                    openFileOutput("prueba_int.txt", Context.MODE_PRIVATE))
            fout.write(texto)
            val toast1 = Toast.makeText(applicationContext, " Se Guardo ", Toast.LENGTH_SHORT)
            toast1.setGravity(Gravity.CENTER, 0, 0)
            toast1.show()

            fout.close()
        } catch (ex: Exception) {
            Log.e("Ficheros", "Error al escribir fichero a memoria interna")
        }

    }
}
