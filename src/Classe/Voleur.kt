package Classe
import personnage.Personnage
import item.Armes
import item.Armure
import item.Item

class Voleur( nom: String,
              pointDeVie: Int,
              pointDeVieMax: Int,
              attaque: Int,
              defense: Int,
              endurance: Int,
              vitesse: Int,
              inventaire: MutableList<Item> = mutableListOf(),
              armePrincipale: Armes?,
              armure: Armure?): Personnage(nom,pointDeVie,pointDeVieMax,attaque,defense,endurance,vitesse,inventaire,armePrincipale, armure) {
    fun voler(cible: Personnage){
        var tirage = (cible.inventaire.indices).random()
        var item = this.inventaire[tirage]
        if(item==cible.armePrincipale){
            cible.armure = null
            this.inventaire.add(item)
            println("${this.nom} a voler $item a ${cible.nom}")
        } else if (item == cible.armePrincipale){
            cible.armure = null
            this.inventaire.add(item)
            println("${this.nom} a voler $item a ${cible.nom}")
        } else {
            println("${this.nom} a rien dans son inventaire")
        }
    }
}

