package com.example.myapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.myapplication.model.CadenaModel
import com.example.myapplication.viewModel.CadenaViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Test
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private lateinit var viewModel: CadenaViewModel

    @get:Rule
    val instantTaskeRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup(){
        Dispatchers.setMain(dispatcher)
        viewModel = CadenaViewModel()
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    //No hay ningun dato en las cadenas por lo tanto es false.
    @Test
    fun cadenaViewModel_TestinicializarElementos() = runTest {
        var valor  = viewModel.cadenaModel.value?.estado
        assertEquals(false,valor)
    }

    //No hay ningun dato en las cadenass por lo tanto es false.
    @Test
    fun cadenaViewModel_TestLosCamposEstanVacios() = runTest {
        var valor  = viewModel.losCamposSonVacios()
        assertEquals(true,valor)
    }


    //La cadena es igual por lo tanto el resultado esperado es true
    @Test
    fun cadenaViewModel_TestCompararElementosIguales() = runTest() {
        launch{
            viewModel.compararDosCadenas("Cadena1","Cadena1")

        }
        advanceUntilIdle()

        val valor = viewModel.cadenaModel.value?.estado
        assertEquals(true,valor)
    }

    //La cadena es distinta por lo tanto el resultado esperado es false.
    @Test
    fun cadenaViewModel_TestCompararElementosDistintos() = runTest() {
        launch{
            viewModel.compararDosCadenas("Cadena1","Cadena2")

        }
        advanceUntilIdle()

        val valor = viewModel.cadenaModel.value?.estado
        assertEquals(false,valor)
    }



}