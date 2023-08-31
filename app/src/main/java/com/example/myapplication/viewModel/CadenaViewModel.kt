package com.example.myapplication.viewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.CadenaModel

class CadenaViewModel : ViewModel() {

    val cadenaModel : LiveData<CadenaModel> get() = _cadenaModel

    private var _cadenaModel =  MutableLiveData<CadenaModel>(CadenaModel("","" , false))

    fun compararDosCadenas(cadenaPrimera: String , cadenaSegunda: String){

        _cadenaModel.value = CadenaModel(cadenaPrimera,cadenaSegunda,(cadenaPrimera) == (cadenaSegunda))

    }

    fun losCamposSonVacios():Boolean{
        return (cadenaModel.value?.cadena1.toString().isEmpty() && cadenaModel.value?.candena2.toString().isEmpty())
    }

}