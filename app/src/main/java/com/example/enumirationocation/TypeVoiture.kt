package com.example.enumirationocation

enum class TypeVoiture(val prix: Double) {
    ECONOMIQUE(300.0),
    INTERMEDIAIRE(450.0),
    SUV(600.0),
    LUXE(1000.0);

   fun tarifJournalier():String{
       return "Type $name Prix: $prix"
   }
}

