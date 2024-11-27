package ejer5

fun main() {
    val partida1 = arrayOf(arrayOf("X", "O", "X"), arrayOf("O", "X", "O"), arrayOf("O", "O", "X"))
    val partida2 = arrayOf(arrayOf("", "O", "X"), arrayOf("", "X", "O"), arrayOf("", "O", "X"))
    val partida3 = arrayOf(arrayOf("O", "O", "O"), arrayOf("O", "X", "X"), arrayOf("O", "X", "X"))
    val partida4 = arrayOf(arrayOf("X", "O", "X"), arrayOf("X", "X", "O"), arrayOf("X", "X", "O"))

    println(verPartida(partida1))
    println(verPartida(partida2))
    println(verPartida(partida3))
    println(verPartida(partida4))
}

fun verPartida(tablero: Array<Array<String>>): String {

    var contadorX = 0
    var contadorO = 0
    var espaciosVacios = 0

    for (fila in tablero) {
        for (celda in fila) {
            if (celda == "X") contadorX++
            else if (celda == "O") contadorO++
            else espaciosVacios++
        }
    }

    val xGana = quienGana(tablero, "X")
    val oGana = quienGana(tablero, "O")

    if (xGana && oGana) return "null"
    if (xGana) return "X"
    if (oGana) return "O"

    return if (espaciosVacios == 0) "tablas" else "null"
}

fun quienGana(tablero: Array<Array<String>>, jugador: String): Boolean {

    if (tablero[0][0] == jugador && tablero[0][1] == jugador && tablero[0][2] == jugador) {
        return true
    }
    if (tablero[1][0] == jugador && tablero[1][1] == jugador && tablero[1][2] == jugador) {
        return true
    }
    if (tablero[2][0] == jugador && tablero[2][1] == jugador && tablero[2][2] == jugador) {
        return true
    }

    if (tablero[0][0] == jugador && tablero[1][0] == jugador && tablero[2][0] == jugador) {
        return true
    }
    if (tablero[0][1] == jugador && tablero[1][1] == jugador && tablero[2][1] == jugador) {
        return true
    }
    if (tablero[0][2] == jugador && tablero[1][2] == jugador && tablero[2][2] == jugador) {
        return true
    }

    if (tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) {
        return true
    }
    if (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador) {
        return true
    }

    return false
}
