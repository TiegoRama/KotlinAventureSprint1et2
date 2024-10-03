package Classe

import item.Armes
import item.Armure
import item.Item
import personnage.Personnage


class Mage (nom: String,
            pointDeVie: Int,
            pointDeVieMax: Int,
            attaque: Int,
            defense: Int,
            endurance: Int,
            vitesse: Int,
            inventaire : MutableList<Item> = mutableListOf(),
            armePrincipal : Armes ?,
            armure: Armure ?,
            val grimoire : MutableList<Sort>): Personnage(nom,pointDeVie,pointDeVieMax,attaque,defense,endurance,vitesse,inventaire,armePrincipal,armure) {

    override fun toString(): String {
        return "Mage  ${super.toString()} (grimoreEquipe = $grimoire"
    }

    fun afficherGrimoire(){
        for(i in grimoire.indices){
            println(" $i => ${grimoire[i]}")
        }
    }

    fun choisirEtLancerSort(cible: Personnage){
        afficherGrimoire()
        if(grimoire.isEmpty()){
            println("Le grimoire est vide, vous ne pouvez pas lancer de sort.")
        } else {
            println("choissisez un sort")
            var i = 0
            val res = readln().toInt()
            //vérifie si l'index est valide
            if(res in grimoire.indices){
                println("Cibles possibles: 0 => ${this.nom}, 1 => ${cible.nom}")
                println("Choissisez la cible")
                val sort = this.grimoire[res]
                val choixcible = readln().toInt()
                //Vérifie si la cible est valide
                if(choixcible !=1 && choixcible != 0){
                    println("Choix de cible invalide")
                } else if(choixcible == 0){
                    grimoire[res].effet(this,this)
                    println("${this.nom} lance le sort ${this.grimoire[res]} sur lui même" )
                } else {
                    grimoire[i].effet(this,cible)
                    println("${this.nom} lance le sort ${this.grimoire[res]} sur ${cible.nom}")
                }
            }
        }
    }

}


