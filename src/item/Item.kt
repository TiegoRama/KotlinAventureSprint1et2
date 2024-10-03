package item

import personnage.Personnage

open class Item (val nom: String, val description : String) {

open fun utiliser(cible: Personnage){

}

    override fun toString(): String {
        return "${nom} (nom= $nom, description= $description"
    }
}