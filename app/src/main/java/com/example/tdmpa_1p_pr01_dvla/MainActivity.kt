package com.example.tdmpa_1p_pr01_dvla

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ElegirConversion()

        var btnCambiar = findViewById<Button>(R.id.btnCambiar)
        btnCambiar.setOnClickListener{
            CambiarFondo()
        }


    }

    fun ElegirConversion (){
        var txtValor = findViewById<TextView>(R.id.txtCantidad)
        var txtResultado = findViewById<TextView>(R.id.txtResultado)
        val radioGroup = findViewById<RadioGroup>(R.id.rbtnGrupo)
        var resultado = 0.0
        radioGroup.setOnCheckedChangeListener{
            _, checkedld -> when (checkedld) {
            R.id.rbtCentimetros -> {
                if (ValidarValor()) {
                    resultado = (txtValor.text.toString().toDouble()) / 2.54
                    txtResultado.text = "${resultado.toString()} in."
                }
            }
                R.id.rbtnPulgadas -> {
                    if (ValidarValor()) {
                        resultado = (txtValor.text.toString().toDouble()) * 2.54
                        txtResultado.text = "${resultado.toString()} cm."
                    }
                }
                    R.id.rbtnMetros -> {
                        if (ValidarValor()) {
                            resultado = (txtValor.text.toString().toDouble()) * 3.281
                            txtResultado.text  = "${resultado.toString()} ft."
                    }
                        }
            R.id.rbtnPies -> {
                if (ValidarValor()) {
                    resultado = (txtValor.text.toString().toDouble()) / 3.281
                    txtResultado.text = "${resultado.toString()} m."
                }
            }
        }
    }
}
    fun ValidarValor(): Boolean {
        var valor = findViewById<TextView>(R.id.txtCantidad)
        if (valor.text.toString().isEmpty()) {
            Toast.makeText(this@MainActivity, "El campo esta vacio ", Toast.LENGTH_SHORT).show()
            return false
        } else {
            return true

        }
    }

    fun CambiarFondo() {
        var urlFondo = "https://images.wallpapersden.com/image/download/super-mario-bros-movie-poster_bW1oa2eUmZqaraWkpJRpbWWtaW1l.jpg"
        val urlParseFondo : Uri = Uri.parse(urlFondo)
        var imgFondo = findViewById<ImageView>(R.id.imgBack)
        Glide.with(applicationContext).load(urlParseFondo).into(imgFondo)
        Toast.makeText(this@MainActivity, "Se realizó el cambio", Toast.LENGTH_SHORT).show()

    }


}
