package com.example.jorgecarrillo.ejemploandroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_crear_usuario.*

class CrearUsuarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_usuario)
        button4
                .setOnClickListener { view: View -> crearUsuario() }
    }

    fun crearUsuario() {
        val nombre = editTextNombreEs.text.toString()
        val apellido = editTextApellido.text.toString()
        val color = editTextColor.text.toString()
        Factory.usuarios.add(Usuario(nombre, apellido, color))
        irAActividadSpinner()
    }
    fun irAActividadSpinner() {
        val intent = Intent(this, Spinner::class.java)
        startActivity(intent)

    Log.i("ciclo-vida", "Ejecuto: On Restart")
}

override fun onResume() {
    super.onResume()
    Log.i("ciclo-vida", "Ejecuto: On Resume")
}

override fun onPause() {
    super.onPause()
    Log.i("ciclo-vida", "Ejecuto: On Pause")
}

override fun onStop() {
    super.onStop()
    Log.i("ciclo-vida", "Ejecuto: On Stop")
}

override fun onDestroy() {
    super.onDestroy()
    Log.i("ciclo-vida", "Ejecuto: On Destroy")
}

override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
    Log.i("ciclo-vida", "Ejecuto: On RestoreInstanceState")
}

override fun onSaveInstanceState(outState: Bundle?) {
    super.onSaveInstanceState(outState)
    Log.i("ciclo-vida", "Ejecuto: On SaveInstanceState")
}
}
