
package com.example.jorgecarrillo.ejemploandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_spinner.*

class Spinner : AppCompatActivity() {

    var arregloUsuarios: ArrayList<Usuario> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        arregloUsuarios = Factory.usuarios

        val adaptadorSpinnerUsuarios = ArrayAdapter<Usuario>(
                this,
                android.R.layout.simple_spinner_item,
                arregloUsuarios)

        adaptadorSpinnerUsuarios
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

         spinner_usuario.adapter= adaptadorSpinnerUsuarios


        spinner_usuario.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Log.i("spinner", "ID: $id Posicion: $position ")

                val usuarioSeleccionado = arregloUsuarios.get(position)

                textViewApellidoGrande.text = usuarioSeleccionado.apellido
                textView_apellido.text = usuarioSeleccionado.apellido
                textView_nombre.text = usuarioSeleccionado.nombre
                textViewcolor.text = usuarioSeleccionado.colorFavorito


            }

        }

    }
}
