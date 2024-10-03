package jeu

import Classes.Guerrier
import Classe.Mage
import Classe.Sort
import Classe.Voleur
import personnage.Personnage



class Jeu(monstres: List<Personnage>) {
    //Le personage du joueur
    lateinit var joueur: Personnage

    //La liste des monstres a combatre
    var combats: MutableList<Combat> = mutableListOf()

    //Le score
    var score: Int = 0

    // Corps du constructeur
    init {
        // Lancement de la création du personage du joueur
        this.creerPersonnage()
        // Pour chaque monstre dans la liste de monstres
        for (unMonstre in monstres) {
            // On crée un combat
            val unCombat = Combat(this, unMonstre)
            combats.add(unCombat)
        }
    }

    fun lancerCombat() {
        for (unCombat in this.combats) {
            unCombat.executerCombat()
            // Mettre à jour le score en fonction du nombre de tours
            val tours = unCombat.nombreTours
            score += calculerScore(tours)
        }
        println("Score final du joueur: $score")
    }

    private fun calculerScore(tours: Int): Int {
        // Par exemple, vous pouvez attribuer plus de points pour moins de tours
        return 500 - tours * 10
    }

    /**
     *  Méthode pour créer le personnage du joueur en demandant les informations à l'utilisateur
     *
     */
    fun creerPersonnage(): Personnage {
        println("Création de votre personnage:")

        var points = 40 // Total des points à distribuer
        println("Vous avez $points points à répartir entre attaque, défense, endurance et vitesse.")
        println("Veuillez rentrer votre nom: ")
        val futurNom = readln()!!.toString()

        var Futurattaque = 0
        var FuturDef = 0
        var Futurendurance = 0
        var Futurvitesse = 0

        // Saisie des points pour chaque caractéristique
        println("Veuillez entrer vos points pour chaque caractéristique (vous avez $points points au total):")

        // Saisie de l'attaque
        do {
            println("Attaque (points restants: $points): ")
            Futurattaque = readln()!!.toInt()
            if (Futurattaque > points) {
                println("Vous ne pouvez pas mettre plus de $points points. Veuillez réessayer.")
            }
        } while (Futurattaque > points)
        points -= Futurattaque

        // Saisie de la défense
        do {
            println("Défense (points restants: $points): ")
            FuturDef = readln()!!.toInt()
            if (FuturDef > points) {
                println("Vous ne pouvez pas mettre plus de $points points. Veuillez réessayer.")
            }
        } while (FuturDef > points)
        points -= FuturDef

        // Saisie de l'endurance
        do {
            println("Endurance (points restants: $points): ")
            Futurendurance = readln()!!.toInt()
            if (Futurendurance > points) {
                println("Vous ne pouvez pas mettre plus de $points points. Veuillez réessayer.")
            }
        } while (Futurendurance > points)
        points -= Futurendurance

        // Saisie de la vitesse
        do {
            println("Vitesse (points restants: $points): ")
            Futurvitesse = readln()!!.toInt()
            if (Futurvitesse > points) {
                println("Vous ne pouvez pas mettre plus de $points points. Veuillez réessayer.")
            }
        } while (Futurvitesse > points)
        points -= Futurvitesse

        // Calcul des points de vie maximum
        val FuturPVMax = 50 + 10 * Futurendurance

        // choisir classe
        val choixClasse = readln().toInt()

        // Création du personnage avec les attributs choisis
        var hero = Personnage(
            futurNom,
            FuturPVMax,
            FuturPVMax,
            Futurattaque,
            FuturDef,
            Futurendurance,
            Futurvitesse,
            joueur.inventaire,
            joueur.armePrincipale,
            joueur.armure
        )

        if(choixClasse == 1){
            hero= Guerrier(futurNom,FuturPVMax,FuturPVMax,Futurattaque,FuturDef,Futurendurance,Futurvitesse,joueur.inventaire,joueur.armePrincipale,joueur.armure )}

        else if(choixClasse == 2){
            hero = Mage(futurNom,FuturPVMax,FuturPVMax,Futurattaque,FuturDef,Futurendurance,Futurvitesse,joueur.inventaire,joueur.armePrincipale,joueur.armure, MutableList<Sort>() )
        }
        else if(choixClasse == 3 ){
            hero = Voleur(futurNom,FuturPVMax,FuturPVMax,Futurattaque,FuturDef,Futurendurance,Futurvitesse,joueur.inventaire,joueur.armePrincipale,joueur.armure)
        }



        // Assignation du personnage créé à la variable this.joueur (si c'est nécessaire dans votre contexte)
        this.joueur = hero
        return hero
    }

}