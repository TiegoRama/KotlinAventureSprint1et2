package Classes

import item.Armes
import item.Armure
import item.Item
import personnage.Personnage

class Guerrier(
    nom: String,
    pointDeVie: Int,
    pointDeVieMax: Int,
    attaque: Int,
    defense: Int,
    endurance: Int,
    vitesse: Int,
    inventaire : MutableList<Item> = mutableListOf(),
    armePrincipal : Armes?,
    armure: Armure?,
    val armeSecondaireEquipe :Armes? =null
): Personnage(nom,pointDeVie,pointDeVieMax,attaque,defense,endurance,vitesse,inventaire,armePrincipal,armure){

    override fun toString(): String {
        return "Guerrier ${super.toString()} (armeSecondaireEquipe = $armeSecondaireEquipe"
    }
    override fun attaque(cible: Personnage){
        var degat=1
        var bonusAttaque = this.attaque/2
        var cibledef = cible.calculeDefense()
        if(armeSecondaireEquipe== null){
            degat = bonusAttaque - cibledef
        } else{
            var total = armeSecondaireEquipe.calculerdegat()
            degat = total + bonusAttaque - cibledef
        }
        if(degat < 1) {degat = 1 }
        cible.pointDeVie-=degat
        if (cible.pointDeVie == 0) {
            cible.pointDeVie = 0
            println("${cible.nom} n'a plus de PV")
            return
        }
        println("$nom attaque ${cible.nom} avec une attaque de base et inflige $degat points de dégâts.")
    }
}