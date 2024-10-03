import item.*
import jeu.Jeu
import personnage.Personnage
import java.lang.reflect.Type

//Créattion des qualités des objets
val qualiteCommun: Qualite = Qualite("commun", 0, "\u001B[32m")
val qualiteRare: Qualite  = Qualite("rare", 1, couleur = "\u001B[34m")
val qualiteEpic: Qualite  = Qualite("epic", 2, "\u001B[35m")
val qualiteLegendaire: Qualite  = Qualite("legendaire", 3, "\u001B[33m")

//TODO Sprint 1 Mission 2A et 2B Création des types d'armes/armures
//Création des types d'armes

val typeepeelongue:TypeArmes = TypeArmes(1,8,2,19)
val typehache:TypeArmes = TypeArmes(1,8,3,20)
val typedague:TypeArmes = TypeArmes(1,4,3,18)
val typebaton:TypeArmes = TypeArmes(1,6,2,20)
val typelance:TypeArmes = TypeArmes(1,8,3,20)
val typearbaletelegere:TypeArmes = TypeArmes(1,8,2,19)
val typeepeecourte:TypeArmes = TypeArmes(1,6,3,19)
val typemarteauguerre:TypeArmes = TypeArmes (1,8,3,20)
val typearclong:TypeArmes = TypeArmes(1,8,3,20)
// Création d'armes
val arclong: Armes = Armes("Arc long", "Arc long",qualiteCommun,typearclong)
val arbaletelegere: Armes = Armes("Arbalète légère","Arbalète pas très lourde",qualiteCommun, typearbaletelegere)
val epeecourte: Armes = Armes("Epée courte","Une petite épée", qualiteCommun,typeepeecourte)
val marteauguerre: Armes = Armes("Marteau de guerre","Gros marteau", qualiteCommun,typemarteauguerre)
val lance: Armes = Armes ("Lance","Lance",qualiteCommun,typelance)
val hache: Armes = Armes("Hache","Hache à 2 mains", qualiteLegendaire,typehache)
val dague : Armes = Armes("Dague", "Dague", qualiteCommun,typedague)
val baton: Armes = Armes("Bâton", "Long bâton", qualiteCommun,typebaton)
val epeelongue: Armes = Armes("Epee Longue","Longue épée", qualiteCommun,typeepeelongue)
// Type d'armure
val typeRembourer: TypeArmure = TypeArmure("Rembouré",1)
val typeCuir: TypeArmure  = TypeArmure("Cuir",2)
val typeCuirCloute: TypeArmure  = TypeArmure("CuirCloute",3)
val typeChemiseAChaine: TypeArmure   = TypeArmure("Chemise à chaine",4)
val typePectoral: TypeArmure  = TypeArmure("Pectoral",5)
val typeCotteDeMailles: TypeArmure  = TypeArmure("Cotte de mailles",6)
// Création d'armures
val Rembourer: Armure = Armure("Armure Rembourer","Rembourer",qualiteCommun,typeRembourer)
val Cuir: Armure = Armure("Armure en cuir","C'est du cuir",qualiteCommun,typeCuir)
val CuirCloute: Armure = Armure("Armure en cuir clouté","C'est du cuir avec des clous",qualiteRare,typeCuirCloute)
val ChemiseAChaine: Armure = Armure("Chemise a fleur","Magnifique chemise avec des fleurs",qualiteLegendaire,typeChemiseAChaine)
val Pectoral: Armure = Armure("Torse nue","La bonne bagarre",qualiteEpic,typePectoral)
val CotteDeMaille: Armure = Armure("Cotte de maille","Armure portée par les chevalier",qualiteEpic,typeCotteDeMailles)


//Création des bombes
val grenade: Bombe = Bombe(5,6,"Grenade","Une contraption qui explose une fois lancée.")
val boombot: Bombe = Bombe(8,5,"Boombot","Petit robot qui explose au contact de la cible")
val cocktail_molotov: Bombe = Bombe(5,7,"Cocktail Molotov","Arme incendiaire artisanale dont le composant principal est un liquide inflammable, habituellement de l'essence ou de l'alcool")
val Spike: Bombe = Bombe(10,7,"Spike","Restez pas dans les parages.")

//Création des potions
val potionDeSoin: Potion = Potion(20,"Potion de soin","Une potion qui contient un liquide rouge.")
val grandePotion: Potion = Potion(30,"Grande potion de soin","Une grande potion qui contient un liquide rouge.")



//TODO Sprint 2 : Création de sorts

fun main(args: Array<String>) {
    // TODO Intemission 4 : Création des items ( armes, armures potions, bombes )

    //Création des monstres
    val gobelin = Personnage(
        "Gob le gobelin",
        pointDeVie = 20,
        pointDeVieMax = 20,
        attaque = 5,
        defense = 4,
        vitesse = 11,
        endurance = 6,
        inventaire = mutableListOf(dague,potionDeSoin,Rembourer,arbaletelegere),
        armePrincipale = dague,
        armure = Rembourer
    )
    val kobold = Personnage(
        "Kob le Kobold",
        pointDeVie = 10,
        pointDeVieMax = 10,
        attaque = 4,
        defense = 4,
        vitesse = 11,
        endurance = 6,
        inventaire = mutableListOf(lance,CuirCloute,grenade,epeecourte),
        armePrincipale = lance,
        armure = CuirCloute
    )
    val troll = Personnage(
        "Groll",
        pointDeVie = 80,
        pointDeVieMax = 80,
        attaque = 15,
        defense = 10,
        vitesse = 5,
        endurance = 10,
        inventaire = mutableListOf(marteauguerre,ChemiseAChaine,potionDeSoin,cocktail_molotov),
        armePrincipale = marteauguerre,
        armure = ChemiseAChaine

    )
    val orc = Personnage(
        "Morc",
        pointDeVie = 40,
        pointDeVieMax = 40,
        attaque = 10,
        defense = 9,
        vitesse = 6,
        endurance = 8,
        inventaire = mutableListOf(grenade,Spike,grandePotion,hache,Pectoral,baton),
        armePrincipale = hache,
        armure = Pectoral
    )
    val Vampire = Personnage(
        "Dracula",
        pointDeVie = 75,
        pointDeVieMax = 95,
        attaque = 30,
        defense = 16,
        vitesse = 16,
        endurance = 25,
        inventaire = mutableListOf(boombot,Spike,grandePotion,CotteDeMaille,epeelongue),
        armePrincipale = epeelongue,
        armure = CotteDeMaille
    )
    val Elfe = Personnage(
        "Elfe des bois",
        pointDeVie = 55,
        pointDeVieMax = 75,
        attaque = 20,
        defense = 16,
        vitesse = 26,
        endurance = 27,
        inventaire = mutableListOf(boombot,cocktail_molotov,grandePotion,Cuir,dague,arclong),
        armePrincipale = arclong,
        armure = Cuir
    )


    // TODO Intermission 1 : Ajouter d'autres monstres

    //TODO On ajoute les monstres a la liste de monstres du jeu
    val jeu = Jeu(listOf( gobelin,kobold,troll,orc,Vampire,Elfe))
    //Lancement du jeu
    jeu.lancerCombat()
}