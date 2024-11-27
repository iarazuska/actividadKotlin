package ejer3

fun main() {
    val expresiones = listOf(
        "{a + b [c] * (2x2)}}}}",
        "{ [ a * ( c + d ) - 5 ] }",
        "{ a * ( c + d ) ] - 5 }",
        "{a^4 + (((ax4)}",
        "{ [ a * ( c + d ) + ( 2 - 3 ) ][ - 5 }",
        "{{{{{{(}}}}}}",
        "(a"
    )
    for (expresion in expresiones) {
        val pila = ArrayList<Char>()
        var bien = true
        for (letra in expresion) {
            if (letra == '(' || letra == '{' || letra == '[') {
                pila.add(letra)
            }
            else if (letra == ')' || letra == '}' || letra == ']') {
                if (pila.isEmpty() || !parejas(pila.removeAt(pila.size - 1), letra)) {
                    bien = false
                    break
                }
            }
        }
        if (pila.isNotEmpty()) {
            bien = false
        }
        println("$expresion $bien")
    }
}

fun parejas(abierto: Char, cerrado: Char): Boolean {
    return (abierto == '(' && cerrado == ')') ||
            (abierto == '{' && cerrado == '}') ||
            (abierto == '[' && cerrado == ']')
}

