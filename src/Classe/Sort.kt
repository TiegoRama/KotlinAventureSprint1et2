package Classe
import Classe.Mage
import item.Armes
import jeu.TirageDes
import personnage.Personnage
import qualiteCommun
import qualiteEpic
import qualiteLegendaire
import qualiteRare
import typeepeelongue

class Sort(val nom:String,val effet:(Personnage, Personnage ) -> Unit) {

val bouledefeu = Sort("Boule de Feu", { caster, cible ->
    run {
        val tirageDes = TirageDes(3, 6)
        var degat = tirageDes.lance()
        degat = maxOf(1, degat - cible.calculeDefense())
        cible.pointDeVie -= degat
        println("La boule de feu inflige $degat à ${cible.nom}")
    }
})
val missilemagique = Sort("Missile magique", { caster, cible ->
    run {
        var compteur = 0
        while(compteur <= 2){
            val tirageDes = TirageDes(1, 6)
            var degat = tirageDes.lance()
            degat = maxOf(1, degat - cible.calculeDefense())
            cible.pointDeVie -= degat
            println("Les missiles magiques infligent $degat à ${cible.nom}")
            compteur += 1
        }

    }


    })
    /**
     * @param nom
     * @param caster
     * On tire 1 dé pour connaitre l'arme qui va être invoqué et ajouter dans l'inventaire'
     */
val invocationarme = Sort("Invocation arme magique", {caster, cible ->
    run {
       val aleatoire = TirageDes(1,20).lance()
        if(aleatoire <= 5){
            val epeecommun = Armes("Epée longue","Longue épée", qualiteCommun, typeepeelongue)
            cible.inventaire.add(epeecommun)
        }
       else if(aleatoire <= 10){
            val epeerare = Armes("Epée longue","Longue épée", qualiteRare, typeepeelongue)
            cible.inventaire.add(epeerare)
    }
        else if(aleatoire <= 15) {
            val epeeepic = Armes("Epée longue", "Longue épée", qualiteEpic, typeepeelongue)
            cible.inventaire.add(epeeepic)
        }else {
            val epeelegendaire = Armes("Epée longue", "Longue épée", qualiteLegendaire, typeepeelongue)
            cible.inventaire.add(epeelegendaire)
            println("Une arme magique a été rajouté à votre inventaire")
            }

}
})

    /**
     * @param nom
     * @param caster
     * On tire 1 dé pour connaitre le soin sur la cible qui est le mage
     */
    val soins = Sort("Soins", { caster, self ->
        run {
            val tirageDes = TirageDes(1, 6)
            var soins = tirageDes.lance()
            self.pointDeVie += soins
            println("Le soin vous soigne $soins à ${self.nom}")
        }
    })}

