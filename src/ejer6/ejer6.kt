package ejer6

import java.util.*

data class agenda(val maximo:Int =3) {
    private val contactos = mutableListOf<String>()

    fun añadir(nombre: String, telefono: String): String {
        if (contactos.size >= maximo) {
            return " agenda llena"
        }
        for (contacto in contactos) {
            if (contacto.startsWith("nombre $nombre")) {
                return "ya exixte"
            }
        }
        contactos.add("nombre $nombre, telefono $telefono")
        return "añadido"
    }

    fun lista(): String {
        if (contactos.isEmpty()) {
            return "vacia"
        }
        var gente = "hay \n"
        for (contacto in contactos) {
            gente += "$contacto\n"
        }
        return gente
    }

    fun buscar(nombre: String): String {
        for (contacto in contactos) {
            if (contacto.startsWith("nombre $nombre")) {
                return "encontrado $contacto"
            }
        }
        return "no existe"
    }


    fun existe(nombre: String): String {
        for (contacto in contactos) {
            if (contacto.startsWith("nombre $nombre")) {
                return "existe"
            }
        }
        return "no existe"
    }

    fun borrar(nombre: String): String {
        for (contacto in contactos) {
            if (contacto.startsWith("nombre $nombre")) {
                contactos.remove(contacto)
                return "borrado "
            }
        }
        return "no existe"
    }

    fun huecos(): String {
        val libres = maximo - contactos.size
        return "huecos $libres"
    }

    fun llena(): String {
        if (contactos.size >= maximo) {
            return "llena"
        }
        return "no esta llena"
    }
}


    fun main() {
        val scanner = Scanner(System.`in`)
        val agenda = agenda()

        while (true) {
            println(
                """
                1 añaddir contacto
                2 lista contactos
                3 buscar contacto
                4 existe contacto 
                5 borrar contacto
                6 sitios libres
                7 esta llena?
                8 salir
            """.trimIndent()
            )

            print("pon una opcion ")
            val opcion = if (scanner.hasNextInt()) scanner.nextInt() else {
                scanner.nextLine()
                -1
            }
            scanner.nextLine()

            when (opcion) {
                1 -> {
                    print("nombre ")
                    val nombre = scanner.nextLine()
                    print("telefono ")
                    val telefono = scanner.nextLine()
                    println(agenda.añadir(nombre, telefono))
                }

                2 -> println(agenda.lista())

                3 -> {
                    print("nombre para buscar  ")
                    val nombre = scanner.nextLine()
                    println(agenda.buscar(nombre))
                }

                4 -> {
                    print("nombre para ver si exixte ")
                    val nombre = scanner.nextLine()
                    println(agenda.existe(nombre))
                }

                5 -> {
                    print("nombre para borrar  ")
                    val nombre = scanner.nextLine()
                    println(agenda.borrar(nombre))
                }

                6 -> println(agenda.huecos())

                7 -> println(agenda.llena())

                8 -> {
                    println("fuera")
                    break
                }

                else -> println("esa opcion no existe")
            }

            println()
        }

    }

