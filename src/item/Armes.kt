package item
import item.*
import jeu.TirageDes
import personnage.Personnage
class Armes ( nom :String,description:String, val qualite : Qualite, val type : TypeArmes):Item(nom,description){
    /**
     * @return les dégats en additionnant les bonus
     */
    fun calculerdegat(): Int {
    // On utilise TirageDes() pour savoir si y'a une attaque critique
    val d20 = TirageDes(1,20).lance()
    var degat = TirageDes(type.nombreDes, type.valeurMax).lance()
    //On multiplie les dégats par le multiplicateur de l'arme
    if(d20 >= type.activationCritique ){ degat *= type.multiplicateurcritique}
return degat + qualite.bonusRarete

}

override fun utiliser(cible : Personnage) {
}
}