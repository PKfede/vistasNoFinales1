package com.example.examen2

import androidx.lifecycle.ViewModel

class gameViewModel: ViewModel() {

    private var questionsComics: List<Question>
    private var currentQuestionComics: Int = 0

    init{
        questionsComics = listOf(
            Question(R.string.quest1_comics, "6","1", "6","5"),
            Question(R.string.quest2_comics, "Jason Todd","Dick Grayson", "Damian Wayne", "Tim Drake"),
            Question(R.string.quest3_comics, "Darkside", "Thanos", "Terrax", "Mongul"),
            Question(R.string.quest4_comics, "Infinity stones", "Anti-Life Equation", "Infinity Gauntlet","Phoenyx Force"),
            Question(R.string.quest5_comics, "Krypton","Metropolis","Gotham","Smallville")
        )
    }

    private var questionsHistoria: List<Question>
    private var currentQuestionHistoria: Int = 0

    init{
        questionsHistoria = listOf(
            Question(R.string.quest1_historia, "XIV","XII","XVI","oreo"),
            Question(R.string.quest2_historia, "Egipcios","Mayas","Aztecas","Batman"),
            Question(R.string.quest3_historia, "1821","1841","1881","2000"),
            Question(R.string.quest4_historia, "Imperio Britanico","Imperio Aleman","Imperio Español","Imperio Galactico"),
            Question(R.string.quest5_historia, "1917","1990","1929","1980")
        )
    }

    private lateinit var questionsVideoJuego: List<Question>
    private var currentQuestionVideoJuego: Int = 0

    init{
        questionsVideoJuego = listOf(
            Question(R.string.quest1_videojuegos, "Final Fantasy","Halo","Half Life","Dark Souls"),
            Question(R.string.quest2_videojuegos, "Dark Souls","Super Mario","The Legend of Zelda","Mario Party"),
            Question(R.string.quest3_videojuegos, "Doom","Super Mario","Half Life","Skyrim"),
            Question(R.string.quest4_videojuegos, "Ninguno","Rojo","Verde","Azul"),
            Question(R.string.quest5_videojuegos, "Blue Shell","Bananna","Red Shell","Green Shell")
        )
    }

    private lateinit var questionsCine: List<Question>
    private var currentQuestionCine: Int = 0

    init{
        questionsCine = listOf(
            Question(R.string.quest1_cine, "22","10","15","20"),
            Question(R.string.quest2_cine, "The Hateful Eight","Kill Bill","Reservoir Dogs","Django"),
            Question(R.string.quest3_cine, "Jurassic Park","King Kong","Godzilla","Cars Edicion Samir"),
            Question(R.string.quest4_cine, "Pixar","Disney","Fox","Universal"),
            Question(R.string.quest5_cine, "Terminator","Yo, Robot<","Robocop","Cortocircuito")
        )
    }

    private lateinit var questionsFisica: List<Question>
    private var currentQuestionFisica: Int = 0

    init{
        questionsFisica = listOf(
            Question(R.string.quest1_fisica, "region del universo a donde se dirige todo","agujero negro en el centro de la galaxia","el centro del universo","fede siendo un iman de pena y deshonra"),
            Question(R.string.quest2_fisica, "el neutrino","el neutron","el boson de higgs","tus sentimientos"),
            Question(R.string.quest3_fisica, "todas son correctas","no hay centro especifico","la frente de samir","la voz de segovia"),
            Question(R.string.quest4_fisica, "El antineutron","No tiene antiparticula","el proton","no se ha descubierto"),
            Question(R.string.quest5_fisica, "Meterte dentro de un coche","subirte al punto mas alto","Ponerte debajo de un arbol","Aceptar tu muert")
        )
    }

    private lateinit var questionsMate: List<Question>
    private var currentQuestionMate: Int = 0

    init{
        questionsMate = listOf(
            Question(R.string.quest1_mate, "Martin Gardner", "Paul Erdos","Albert Einstein","zeta"),
            Question(R.string.quest2_mate, "2 potencia infinito", "ans2_mate2", "2 x infinito", "todos son iguales"),
            Question(R.string.quest3_mate, "4000 veces la poblacion de la tierra", "poblacion mundial x 2","la mitad de marte", "el mismo peso de mi orgullo"),
            Question(R.string.quest4_mate, "La cuadratura del circulo","","que todos los numeros son la suma de 3 capicuas","que todos los numeros son la suma de dos primos"),
            Question(R.string.quest5_mate, "4","5", "oreo", "+un patio+")
        )
    }

    public val numOfQuestion
        get() = questionsCine.size

    public fun getCurrentQuestion() = questionsCine[currentQuestionCine]

    public fun nextQuestion(){
        currentQuestionCine = (currentQuestionCine + 1) % questionsCine.size
    }
    public fun previousQuestion(){
        currentQuestionCine = (currentQuestionCine + questionsCine.size - 1) % questionsCine.size
    }
}
