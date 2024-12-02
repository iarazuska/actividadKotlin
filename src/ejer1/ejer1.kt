package ejer1
fun main(){
    for (listaNumeros in 1..100){

        //pagina 47 del pdf
        if (listaNumeros % 3 == 0 && listaNumeros % 5 == 0) {
            println("triqui")
        } else if (listaNumeros % 3 == 0) {
            println("tri")
        } else if (listaNumeros % 5 == 0) {
        } else {
            println("$listaNumeros")
        }

    }

}