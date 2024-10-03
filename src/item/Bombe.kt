package item

import jeu.TirageDes
import personnage.Personnage

class Bombe(var nombreDeDes: Int ,var maxDe : Int,  nom : String , description : String ): Item(nom,description) {
    /**
     * @param cible qui prend le personnage
     * @param armure qui prend l'amure du personnage
     * @param personnage
     * @return les dégats que la cible se prend
     */
    fun utiliser(cible : Personnage, armure: Armure ,personnage: Personnage): Int {
        val degat = TirageDes(nombreDeDes, maxDe).lance()
        val resultat = degat - (armure.calculProtection() - personnage.defense)
        return resultat
    }

}