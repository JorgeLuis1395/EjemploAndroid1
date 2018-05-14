package com.example.jorgecarrillo.ejemploandroid

import android.content.Intent
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_actividad2.*
import kotlinx.android.synthetic.main.activity_main.*

class Actividad2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad2)
        val nombre = intent.getStringExtra("nombre")
        nombreTextView.text= nombre
        button2.setOnClickListener{v: View? -> irActividad3() }
        buttonContactos.setOnClickListener{v: View? -> enviarCorreo()  }
        buttonEnviarCorreo.setOnClickListener{v: View? -> seleccionarUnContacto() }
    }
    fun irActividad3(){
        val intent = Intent(this,Actividad3::class.java)
        startActivity(intent)
}
    fun enviarCorreo() {
        val addressees = arrayOf("direccion@uno.com", "direccion@dos.com")
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/html"
        intent.putExtra(Intent.EXTRA_EMAIL, addressees)
        intent.putExtra(Intent.EXTRA_SUBJECT, "Sujeto")
        intent.putExtra(Intent.EXTRA_TEXT, "Texto.")
        startActivity(intent)
    }

    fun seleccionarUnContacto() {
        val intent = Intent(Intent.ACTION_PICK,
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
        startActivityForResult(intent, RESPUESTA_DE_CONTACTO)
    }

    companion object {
        val RESPUESTA_DE_CONTACTO = 1;
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        Log.i("etiqueta", "El request code es: ${requestCode}")

        when (requestCode) {
            RESPUESTA_DE_CONTACTO -> {
                if (resultCode == RESULT_OK) {
                    var cursor: Cursor? = null
                    try {
                        var phoneNo: String? = null
                        var name: String? = null
                        val uri = intent?.data
                        cursor = contentResolver.query(uri, null, null, null, null)
                        cursor!!.moveToFirst()
                        val phoneIndex = cursor!!.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                        val nameIndex = cursor!!.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                        phoneNo = cursor!!.getString(phoneIndex)
                        name = cursor!!.getString(nameIndex)



                        contactosTextView.text = phoneNo
                        correoTextView.text = name




                        Log.i("create", "Nombre ${name}")
                        Log.i("create", "Numero de telefono ${phoneNo}")


                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                if (resultCode == RESULT_CANCELED) {
                    Log.i("create", "El usuario cancelo")
                }}}}}
