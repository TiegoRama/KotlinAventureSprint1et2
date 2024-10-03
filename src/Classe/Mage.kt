package Classe

import item.Armes
import item.Armure
import item.Item
import personnage.Personnage

class Mage( nom: String,
            pointDeVie: Int,
            pointDeVieMax: Int,
            attaque: Int,
            defense: Int,
            endurance: Int,
            vitesse: Int,
            inventaire: MutableList<Item> = mutableListOf(),
            armePrincipale: Armes?,
            armure: Armure?): Personnage(nom,pointDeVie,pointDeVieMax,attaque,defense,endurance,vitesse,inventaire,armePrincipale, armure) {
}