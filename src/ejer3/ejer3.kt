package ejer3

fun main() {
    val expresiones = listOf(
        "{a + b [c] * (2x2)}}}}",
        "{ [ a * ( c + d ) - 5 ] }",
        "{ a * ( c + d ) - 5 }",
        "a^4 + ((4x4))",
        "{ [ a * ( c + d ) + ( 2 - 3 ) ][ - 5 }",
        "{{{{{{}}}}}}",
        "(a"
    )

    for (expresion in expresiones) {
        val apertura = ArrayList<Char>()
        val cierre = ArrayList<Char>()
        var bien = true

        for (letra in expresion) {
            if (letra == '(' || letra == '{' || letra == '[') {
                apertura.add(letra)
            } else if (letra == ')' || letra == '}' || letra == ']') {
                cierre.add(letra)
            }
            if (apertura.isEmpty() || !parejas(apertura.removeAt(apertura.size - 1), letra)) {
                bien = false
                break

            }

            if (apertura.isNotEmpty() || cierre.isNotEmpty()) {
                bien = false
            }


        }
        println("$expresion $bien")

    }

}

fun parejas(abierto: Char, cerrado: Char): Boolean {
    return (abierto == '(' && cerrado == ')') ||
            (abierto == '{' && cerrado == '}') ||
            (abierto == '[' && cerrado == ']')

}

