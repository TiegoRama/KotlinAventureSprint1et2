package item
import personnage.Personnage

class Armure(nom : String , description : String, val qualite: Qualite, val type: TypeArmure):Item(nom,description) {
    /**
     * @return on additionne les bonus d'armure
     */
    fun calculProtection():Int{
       // on additionne les bonus de l'armure
        return type.BonusProtection + qualite.bonusRarete
    }
    fun utilser(cible : Personnage){

    }


}