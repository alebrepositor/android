package com.example.myapplication

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith






@RunWith(AndroidJUnit4::class)

class MainActivityTest {

    //Escenario encargado de gestionar el ciclo de vida del activity
    @get:Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    //Comparar las cadena de texto sin ingresar texto
    @Test
    fun mainActivity_compararCadenaAlInicio() {
        Espresso.onView(
            ViewMatchers.withId(R.id.botonResultado) //Se obtiene la vista mediante el identidicador botonResultado
        ).perform(
            ViewActions.click() //Se presiona el boton.
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.cadenaResultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Esperando Comparacion...")
            )
        )

    }

    //Comparar cadena de texto con los parametros iguales
    @Test
    fun mainActivity_compararCadenaConParametrosCorrectos() {
        Espresso.onView(
            ViewMatchers.withId(R.id.primeraCadena)
        ).perform(
            ViewActions.replaceText("Hola")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.segundaCadena)
        ).perform(
            ViewActions.replaceText("Hola")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.botonResultado) //Se obtiene la vista mediante el identidicador botonResultado
        ).perform(
            ViewActions.click() //Se presiona el boton.
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.cadenaResultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("La cadena es Correcta")
            )
        )

    }

    //Comparar las cadenas de texto con distintos parametros.
    @Test
    fun mainActivity_compararCadenaConParametrosIncorrectos() {
        Espresso.onView(
            ViewMatchers.withId(R.id.primeraCadena)
        ).perform(
            ViewActions.replaceText("Hola")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.segundaCadena)
        ).perform(
            ViewActions.replaceText("Chao")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.botonResultado) //Se obtiene la vista mediante el identidicador botonResultado
        ).perform(
            ViewActions.click() //Se presiona el boton.
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.cadenaResultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("La cadena es Incorrecta")
            )
        )

    }
}