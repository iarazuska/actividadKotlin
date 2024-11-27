package ejer4

fun main() {
    val carrera = ejer4()

    println(carrera.Carrera(listOf("correr", "saltar", "correr", "saltar", "correr"), "_|_|_"))
    println(carrera.Carrera(listOf("correr", "correr", "correr", "saltar", "correr"), "_|_|_"))
    println(carrera.Carrera(listOf("correr", "correr", "saltar", "saltar", "correr"), "_|_|_"))
    println(carrera.Carrera(listOf("correr", "saltar", "correr", "saltar"), "_|_|_"))
    println(carrera.Carrera(listOf("correr", "saltar", "saltar", "correr", "correr"), "_|_"))
    println(carrera.Carrera(listOf("saltar", "saltar", "saltar"), "||"))
}

class ejer4 {

    fun Carrera(acciones: List<String>, pista: String): Boolean {
        var pistaNueva = ""
        var victoria = true
        //compara la cantidad de espacio que tiene las dos listas
        val max = maxOf(acciones.size, pista.length)
        for (i in 0 until max) {
            //si es mas largo que pista pone ?
            if (i >= pista.length) {
                pistaNueva += "?"
                victoria = false
                //si tiene la misma longitud se empieza
            } else if (i >= acciones.size) {
                pistaNueva += pista[i]
            } else {

                val obstaculo = pista[i]
                val paso = acciones[i]

                when {
                    paso == "correr" && obstaculo == '_' -> pistaNueva += "_"
                    paso == "saltar" && obstaculo == '|' -> pistaNueva += "|"
                    paso == "correr" && obstaculo == '|' -> {
                        pistaNueva += "/"
                        victoria = false
                    }
                    paso == "saltar" && obstaculo == '_' -> {
                        pistaNueva += "x"
                        victoria = false
                    }
                    else -> {
                        pistaNueva += "?"
                        victoria = false
                    }
                }
            }
        }

        println("pista  $pista")
        println("pista nueva  $pistaNueva")

        return victoria
    }
}


