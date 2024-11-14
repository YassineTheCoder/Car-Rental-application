package com.example.enumirationocation

class Location(private val voiture: Voiture, private val jourLocation: Int) {

    init {
        require(jourLocation > 0) { "Le nombre de jours doit être supérieur à 0" }
    }

    fun calculerCouTotal(): Double {
        return jourLocation * voiture.typeVoiture.prix
    }

    fun afficherDetails(): String {
        return """
            Nombre de jours: $jourLocation
            Prix par jour: ${voiture.typeVoiture.prix} MAD
            Prix total: ${calculerCouTotal()} MAD
        """.trimIndent()
    }
}
