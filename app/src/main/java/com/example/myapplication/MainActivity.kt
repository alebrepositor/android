package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewModel.CadenaViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainActivity : CadenaViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        mainActivity.cadenaModel.observe(this){

            if ( ! mainActivity.losCamposSonVacios()){ //Verificar si los campos no estan vacios.

                if ( it.estado  ){
                    binding.cadenaResultado.text = "La cadena es Correcta"
                }
                else {
                    binding.cadenaResultado.text = "La cadena es Incorrecta"
                }
            }
            else {
                binding.cadenaResultado.text = "Esperando Comparacion..."
            }

        }

        binding.botonResultado.setOnClickListener {

            //Se asigna las variables con los datos del textView en la vista.
            var primeraCadena = binding.primeraCadena.text.toString()
            var segundaCadena = binding.segundaCadena.text.toString()

            //Se llama al metodo para comparar dos cadenas del viewModel.
            mainActivity.compararDosCadenas(primeraCadena,segundaCadena)

        }

        //Limpia los campos Primera y Segunda cadena.
        binding.botonReset.setOnClickListener {

            binding.primeraCadena.text.clear()
            binding.segundaCadena.text.clear()
            binding.cadenaResultado.text = "Esperando Comparacion..."


        }

    }

}