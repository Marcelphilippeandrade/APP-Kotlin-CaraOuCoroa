package com.cursoandroidkotlin.marcelphilippe.caraoucoroa

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val dados: Bundle? = intent.extras
        val numero = dados?.getInt("numero")

        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.musica_jogo)
        mediaPlayer?.start()

        if(numero == 0){
            image_resultado.setImageResource(R.drawable.moeda_cara)
            Toast.makeText(applicationContext, "Deu Cara!", Toast.LENGTH_LONG).show()
        }else{
            image_resultado.setImageResource(R.drawable.moeda_coroa)
            Toast.makeText(applicationContext, "Deu Coroa!", Toast.LENGTH_LONG).show()
        }

        button_voltar.setOnClickListener {
            finish()
            mediaPlayer?.stop()
        }
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.stop()
    }
}