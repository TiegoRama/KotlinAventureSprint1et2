package jeu
import item.Armes
import item.Item
import item.Potion
import kotlin.random.Random
import personnage.Personnage

class Combat(
    val jeu :Jeu,
    val monstre: Personnage
) {
    var nombreTours: Int = 1

    // Méthode pour simuler un tour de combat du joueur
    fun tourDeJoueur() {
        println("\u001B[34m ---Tour de ${this.jeu.joueur.nom} (pv: ${this.jeu.joueur.pointDeVie}) ---")

        val actions = mutableMapOf(
            1 to "Attaquer",
            2 to "Boire potion",
            3 to "Passer",
            4 to "Utiliser un objet"
        )

        // Affichage des actions disponibles
        println("Choisir une action :")
        for (uneAction in actions) {
            println(" ${uneAction.key} - ${uneAction.value}")
        }

        var choixValide = false
        while (!choixValide) {
            val choix = readln()

            when (choix) {
                "1" -> { // Attaquer
                    choixValide = true
                    this.jeu.joueur.attaque(monstre)
                }
                "2" -> { // Boire une potion
                    choixValide = true
                    println("Vous avez bu une potion")
                    this.jeu.joueur.boirePotion()
                }
                "3" -> { // Passer son tour
                    choixValide = true
                    println("Vous passez votre tour.")
                }
                "4" -> { // Utiliser un objet
                    choixValide = true
                    this.jeu.joueur.afficherinventaire()
                    var choixObjetValide = false
                    while (!choixObjetValide) {
                        println("Choisissez un objet en saisissant l'index correspondant :")
                        val index = readln().toIntOrNull()  // Lecture de l'index

                        if (index != null && index in 0 until this.jeu.joueur.inventaire.size) {
                            val objet = this.jeu.joueur.inventaire[index]
                            println("Vous avez choisi d'utiliser ${objet.nom}.")
                            objet.utiliser(this.jeu.joueur)  // Utiliser l'objet sélectionné
                            choixObjetValide = true
                        } else {
                            println("Index invalide. Veuillez réessayer.")
                        }
                    }
                }
                else -> {
                    println("Mauvaise saisie !!!")
                }
            }
        }
        println("\u001b[0m")
    }

    // Méthode pour simuler un tour de combat du monstre
    /**
     * On rend les attaques des ennemies de manière aléatoire en important le module Random
     *
     */
    fun tourDeMonstre() {
        println("\u001B[31m---Tour de ${monstre.nom} (pv: ${monstre.pointDeVie}) ---")
        //TODO Mission 1.3
        var random = (1..100).random()
        if (random<=70){
        this.monstre.attaque(this.jeu.joueur)}
        if(monstre.avoirPotion()){
            if(monstre.pointDeVieMax / monstre.pointDeVie >= 2){
               if(random <= 10){
                monstre.boirePotion()
            }
        }
        }





        println("\u001b[0m")
    }

    // Méthode pour exécuter le combat complet
    fun executerCombat() {
        println("Début du combat : ${this.jeu.joueur.nom} vs ${monstre.nom}")
        //La vitesse indique qui commence
        var tourJoueur = this.jeu.joueur.vitesse >= this.monstre.vitesse
        //Tant que le joueur et le monstre sont vivants
        while (this.jeu.joueur.pointDeVie > 0 && monstre.pointDeVie > 0) {
            println("Tours de jeu : ${nombreTours}")
            if (tourJoueur) {
                tourDeJoueur()
            } else {
                tourDeMonstre()
            }
            nombreTours++
            tourJoueur = !tourJoueur // Alternance des tours entre le joueur et le monstre
            println("${this.jeu.joueur.nom}: ${this.jeu.joueur.pointDeVie} points de vie | ${monstre.nom}: ${monstre.pointDeVie} points de vie")
            println("")
        }

        if (this.jeu.joueur.pointDeVie <= 0) {
            println("Game over ! ${this.jeu.joueur.nom} a été vaincu !")
            println("Le combat recommence")

            this.jeu.joueur.pointDeVie = this.jeu.joueur.pointDeVieMax
            this.monstre.pointDeVie = this.monstre.pointDeVieMax
            this.executerCombat()
        } else {
            println("BRAVO ! ${monstre.nom} a été vaincu !")
        }
    }

}