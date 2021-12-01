package tads.eaj.ufrn.exemplorecursos

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.TextViewCompat

class MainActivity : AppCompatActivity() {

    lateinit var mp:MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Toast.makeText(this, R.string.saudacao, Toast.LENGTH_SHORT).show()

        val texto:TextView = findViewById(R.id.texto)

        texto.setText(R.string.app_name)
        texto.text =  applicationContext.getString(R.string.app_name)

        //texto.setTextColor(ContextCompat.getColor(this, R.color.purple_700))

        TextViewCompat.setTextAppearance(texto, R.style.tamtexto)

        val grupo:RadioGroup = findViewById(R.id.radiogroup)

        when(grupo.checkedRadioButtonId){
            R.id.radioButton ->{

            }
            R.id.radioButton2 ->{
                
            }
        }



        /*
        val texto: TextView = findViewById(R.id.texto)
        texto.setText(R.string.app_name)
        texto.text = getString(R.string.app_name)

        //texto.setTextColor(ContextCompat.getColor(this, R.color.purple_700))
        TextViewCompat.setTextAppearance(texto, R.style.fontes)
         */



        mp = MediaPlayer.create(this, R.raw.sound_sample)
    }

    fun play(v: View){
        mp.start()
        mp.setOnCompletionListener {
            mp.start()
        }
    }

    fun pause(v:View){
        mp.pause()
    }

    fun stop(v:View){
        mp.stop()
        mp.release()
    }

    override fun onStop() {
        mp.stop()
        mp.release()
        super.onStop()
    }
}