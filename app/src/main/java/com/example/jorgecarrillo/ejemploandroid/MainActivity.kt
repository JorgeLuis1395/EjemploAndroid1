package com.example.jorgecarrillo.ejemploandroid

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(toolbar)
        val permisosDeCamara = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA
        )

        val permisosDeSendSms = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS
        )

        val noTienePermisosDeCamara = permisosDeCamara != PackageManager.PERMISSION_GRANTED

        val noTienePermisosDeSendSms = permisosDeSendSms != PackageManager.PERMISSION_GRANTED

        if (noTienePermisosDeCamara && noTienePermisosDeSendSms) {

            Log.i("tag", "Entrando a pedir permiso")

            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.CAMERA,
                            Manifest.permission.SEND_SMS),
                    RESULTADO_PERMISO_CAMARA)

        } else {
            Log.i("tag", "Ya tiene este permiso")
        }
        button.setOnClickListener { view: View -> irActividad2()
        }
        buttonSpinner.setOnClickListener{v: View? ->  irAActividadSpinner()}
        buttonCrear.setOnClickListener{v: View? -> irAActividadCrearUsuario() }
        buttonLeerArchivo.setOnClickListener { v: View? -> irLecturadeArchivos() }
        buttonEscribirArchivo.setOnClickListener { v: View? -> irescribirArchivos() }
        buttonBase.setOnClickListener{v: View? -> irActividadBaseDatos() }
        buttonFrames.setOnClickListener{ v: View? -> irFrames() }
    }
    fun irActividad2(){
       val intent = Intent(this, Actividad2::class.java)
        intent.putExtra("nombre","Jorge Carrillo")
        startActivity(intent)
    }
    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<String>,
            grantResults: IntArray) {
        when (requestCode) {
            RESULTADO_PERMISO_CAMARA -> {
                Log.i("etiqueta", "Recibimos resultado")
            }
        }
    }


    companion object {
        val RESULTADO_PERMISO_CAMARA = 1;
    }
    fun irAActividadSpinner() {
        val intent = Intent(this, Spinner::class.java)
        startActivity(intent)
    }

    fun irAActividadCrearUsuario() {
        val intent = Intent(this, CrearUsuarioActivity::class.java)
        startActivity(intent)
    }
    fun irActividadBaseDatos(){
        val intent = Intent (this,BaseDatos::class.java)
        startActivity(intent)
    }
    fun irFrames(){
        val intent = Intent(this,Frames::class.java)
        startActivity(intent)
    }

    fun irLecturadeArchivos() {
        val intent = Intent(this, LecturaArchivos::class.java)
        startActivity(intent)

    }
    fun irescribirArchivos() {
        val intent = Intent(this, escrituraArchivos::class.java)
        startActivity(intent)

    }
}
