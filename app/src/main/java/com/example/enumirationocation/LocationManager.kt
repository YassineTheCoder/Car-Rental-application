package com.example.enumirationocation

class LocationManager {
    fun calculateRentalDetails(type: TypeVoiture, jours: Int): String {
        val voiture = Voiture(1, "Marque", "Modele", type)

        val location = Location(voiture, jours)

        return location.afficherDetails()
    }
}
