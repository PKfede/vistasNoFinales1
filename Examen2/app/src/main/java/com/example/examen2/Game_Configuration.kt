package com.example.examen2

class Game_Configuration {
    var all_categories : Boolean = true
    var categories: List<Category> = listOf(
        Category(0, questions = listOf(
            Question(1, "6","1", "6","5"),
            Question(2, "Jason Todd","Dick Grayson", "Damian Wayne", "Tim Drake"),
            Question(3, "Darkside", "Thanos", "Terrax", "Mongul"),
            Question(4, "Infinity stones", "Anti-Life Equation", "Infinity Gauntlet","Phoenyx Force"),
            Question(5, "Krypton","Metropolis","Gotham","Smallville")
        )),
        Category(1, questions = listOf(
            Question(1, "XIV","XII","XVI","oreo"),
            Question(2, "Egipcios","Mayas","Aztecas","Batman"),
            Question(3, "1821","1841","1881","2000"),
            Question(4, "Imperio Britanico","Imperio Aleman","Imperio Español","Imperio Galactico"),
            Question(5, "1917","1990","1929","1980")
        )),Category(2, questions = listOf(
            Question(1, "Final Fantasy","Halo","Half Life","Dark Souls"),
            Question(2, "Dark Souls","Super Mario","The Legend of Zelda","Mario Party"),
            Question(3, "Doom","Super Mario","Half Life","Skyrim"),
            Question(4, "Ninguno","Rojo","Verde","Azul"),
            Question(5, "Blue Shell","Bananna","Red Shell","Green Shell")
        )),
        Category(3, questions = listOf(
            Question(1, "22","10","15","20"),
            Question(2, "The Hateful Eight","Kill Bill","Reservoir Dogs","Django"),
            Question(3, "Jurassic Park","King Kong","Godzilla","Cars Edicion Samir"),
            Question(4, "Pixar","Disney","Fox","Universal"),
            Question(5, "Terminator","Yo, Robot<","Robocop","Cortocircuito")
        )),
        Category(4, questions = listOf(
            Question(1, "region del universo a donde se dirige todo","agujero negro en el centro de la galaxia","el centro del universo","fede siendo un iman de pena y deshonra"),
            Question(2, "el neutrino","el neutron","el boson de higgs","tus sentimientos"),
            Question(3, "todas son correctas","no hay centro especifico","la frente de samir","la voz de segovia"),
            Question(4, "El antineutron","No tiene antiparticula","el proton","no se ha descubierto"),
            Question(5, "Meterte dentro de un coche","subirte al punto mas alto","Ponerte debajo de un arbol","Aceptar tu muert")
        )),
        Category(5, questions = listOf(
            Question(1, "Martin Gardner", "Paul Erdos","Albert Einstein","zeta"),
            Question(2, "2 potencia infinito", "ans2_mate2", "2 x infinito", "todos son iguales"),
            Question(3, "4000 veces la poblacion de la tierra", "poblacion mundial x 2","la mitad de marte", "el mismo peso de mi orgullo"),
            Question(4, "La cuadratura del circulo","","que todos los numeros son la suma de 3 capicuas","que todos los numeros son la suma de dos primos"),
            Question(5, "4","5", "oreo", "+un patio+")
        ))
    )
    private var categoriesNumber = 6

    val arrayQuestionsNumber = arrayOf(5, 6, 7, 8, 9,10)
    val arrayCluesNumber = arrayOf(1, 2, 3)

    var questions_number : Int = 5
    var dificulty : Int = 0
    var cluesOn : Boolean = false
    var clues_number: Int = 1


    fun getCheckedCategory(pos:Int): Boolean {
        return categories[pos].isEnabled
    }
    fun getNumOfCategories(): Int{
        return categoriesNumber
    }
    fun setEnabledCategory(pos:Int, value: Boolean){
        categories[pos].isEnabled = value
        if(value){
            if(categoriesNumber < 6){
                categoriesNumber++
            }
        }
        else{
            categoriesNumber--
        }
    }
}