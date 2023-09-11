package com.ana.lab_1_punto3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.ana.lab_1_punto3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.Base_Theme_Lab_1_Punto3)
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)


        mainBinding.conversorButton.setOnClickListener {
            val converText = mainBinding.conversorEditText.text.toString()

            if (converText.isNotEmpty()) {
                val conver = converText.toDouble()

                var resultado = ""
                if (mainBinding.euroButton.isChecked) {
                    val conversionEuro = conver * 0.00023
                    resultado = String.format("%.2f COP = %.2f Euro (EUR)", conver, conversionEuro)
                } else if (mainBinding.dollarButton.isChecked) {
                    val conversionDolar = conver * 0.00025
                    resultado = String.format("%.2f COP = %.2f Dólar estadounidense (USD)", conver, conversionDolar)
                } else if (mainBinding.francoButton.isChecked) {
                    val conversionCHF = conver * 0.00022
                    resultado = String.format("%.2f COP = %.2f Franco Suizo (CHF)", conver, conversionCHF)
                } else if (mainBinding.libraButton.isChecked) {
                    val conversionGBP = conver * 0.00020
                    resultado = String.format("%.2f COP = %.2f Libra Esterlina (GBP)", conver, conversionGBP)
                } else if (mainBinding.pesoMexButton.isChecked) {
                    val conversionMXN = conver * 0.0043
                    resultado = String.format("%.2f COP = %.2f Peso Mexicano (MXN)", conver, conversionMXN)
                } else if (mainBinding.dollarCadButton.isChecked) {
                    val conversionCAD = conver * 0.00034
                    resultado = String.format("%.2f COP = %.2f Dólar Canadiense (CAD)", conver, conversionCAD)
                }

                mainBinding.resultText.text = resultado
            } else {
                val alertDialog = AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Debes llenar los campos necesarios para realizar la conversión")
                    .setPositiveButton("OK", null)
                    .create()

                alertDialog.show()
            }
        }
    }
}