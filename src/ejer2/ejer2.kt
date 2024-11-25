package ejer2

fun main() {
    println("palabra 1")
    val palabra1 = readln()

    println("palabra 2")
    val palabra2= readln()

    if(palabra1==palabra2){
        println("$palabra1 y $palabra2 no son anagramas")
    }else{
        println("$palabra1 y $palabra2 son anagramas")
    }

}