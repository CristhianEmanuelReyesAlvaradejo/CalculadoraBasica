package com.example.calculadorabasica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var num1 = 0.00
    var num2 = 0.00
    var ope = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultado.text = "0"
        cero.setOnClickListener{precionado("0")}
        b1.setOnClickListener{precionado("1")}
        b2.setOnClickListener{precionado("2")}
        b3.setOnClickListener{precionado("3")}
        b4.setOnClickListener{precionado("4")}
        b5.setOnClickListener{precionado("5")}
        b6.setOnClickListener{precionado("6")}
        b7.setOnClickListener{precionado("7")}
        b8.setOnClickListener{precionado("8")}
        b9.setOnClickListener{precionado("9")}
        punto.setOnClickListener{precionado(".")}
        masmenos.setOnClickListener {
            num1 = num1*(-1)
        }

        limpiar.setOnClickListener{
            num1 = 0.00
            num2 = 0.00
            resultado.text = "0"
            ope = noope
        }

        igual.setOnClickListener {
            var resul= when(ope)
            {
                suma -> num1+num2
                resta -> num1-num2
                multi -> num1*num2
                division -> num1/num2
                porcentaje -> (num1/100)*num2
                else -> 0
            }
            resultado.text = resul.toString()
        }

        mas.setOnClickListener { operacion(suma) }
        menos.setOnClickListener { operacion(resta) }
        por.setOnClickListener { operacion(multi) }
        divi.setOnClickListener { operacion(division) }
        porcen.setOnClickListener { operacion(porcentaje) }

    }

    private fun precionado(num: String)
    {
        if(resultado.text == "0" && num != ".")
        {
            resultado.text = "$num"
        }
        else
        {
            resultado.text = "${resultado.text}$num"
        }

        if(ope == noope)
        {
            num1 = resultado.text.toString().toDouble()

        }
        else
        {
            num2 = resultado.text.toString().toDouble()
        }
    }

    private fun operacion(op: Int)
    {
        this.ope = op
        resultado.text = "0"
    }

    companion object
    {
        const val suma = 1
        const val resta = 2
        const val multi = 3
        const val division = 4
        const val porcentaje = 5
        const val noope = 0

    }
}