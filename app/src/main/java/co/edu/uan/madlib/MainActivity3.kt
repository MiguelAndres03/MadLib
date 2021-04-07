package co.edu.uan.madlib

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main3.*
import java.lang.StringBuilder
import java.util.*

class MainActivity3 : AppCompatActivity() {
    val generate: String = "madlib1_tarzan2"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val inputs = intent.getStringArrayExtra("dato")

        storyfin(inputs, resources.getIdentifier(generate, "raw", packageName))

        val gou =findViewById<Button>(R.id.boton3)

        gou.setOnClickListener() {

            val intent = Intent( this@MainActivity3, MainActivity::class.java)

            startActivity(intent)    }

    }

    fun storyfin(inputs: Array<String>?, idir: Int){
        val builder = StringBuilder()
        val scan = Scanner(resources.openRawResource(idir))
        val L = scan.nextLine()
        builder.append(L)

        while(scan.hasNextLine()){
            val line = scan.nextLine()
            builder.append(" ")
            builder.append(line)
        }

        var `val` = builder.toString()
        val reg = Regex("<.*?>")
        val blanco = reg.findAll(`val`).map { it.value }
        var i: Int = 0
        for(blanco in blanco){
            if (inputs != null) {
                `val` = `val`.replaceFirst(blanco, inputs.get(i))
                i++
            }

        }
        texto5.text = "$`val`"
    }

}