					Les Arbres
					
/* ArbreBinaireG.java ** Created on 13 janvier 2005, 21:16*
 * @author  Fildz */
public interface ArbreBinaireG 
{
    public void prefixe() ;
    public void postfixe();
    public void infixe() ;
    public Object racine() ;
    public ArbreBinaireG ArbreGauche() ;
    public ArbreBinaireG ArbreDroit() ;
    public boolean appartient(Object s) ;
}

/*  La classe Arbre Binaire */
public class ArbreBin2 implements ArbreBinaireG {
    ArbreBin2 arbreGauche ;
    ArbreBin2 arbreDroit ;
    //Class typeDesElements ;
    Object Etiquette ;
    
    
    public ArbreBin2( Object E, ArbreBin2 D, ArbreBin2 G ) {
       // typeDesElements = type ;
        Etiquette = E ;
        arbreGauche = G ;
        arbreDroit = D; 
    }
       
    public ArbreBinaireG ArbreDroit() { return arbreDroit ; }
    
    public ArbreBinaireG ArbreGauche() { return arbreGauche ; }
    
    public boolean appartient(Object s) {
    
        if (Etiquette == null) return false ;
        if (Etiquette.equals(s)) return true ; // on considere donc que Etiquette est Forcement un String
        if (arbreGauche != null && ArbreGauche().appartient(s)) return true;
        if (arbreDroit != null && ArbreDroit().appartient(s)) return true;
        return false ;       
    }
    
    public void infixe() {
        
        if (arbreGauche != null)
            arbreGauche.infixe() ;
        System.out.print(Etiquette + " ");
        if (arbreDroit != null)
            arbreDroit.infixe() ;
    }
    
    public void postfixe() {
        if (arbreGauche != null)
            arbreGauche.postfixe();
        if (arbreDroit != null)
            arbreDroit.postfixe();
        System.out.print(Etiquette + " ");                
    }
    
    public void prefixe() {
        System.out.print(Etiquette + " ");
        if (arbreGauche != null)
            arbreGauche.prefixe();
        if (arbreDroit != null)
            arbreDroit.prefixe() ;
    }
    
    public Object racine() { return Etiquette ; }
}

/*  Classe de test ecrivant mon Prenom */
public class ArbreNomPrenom {
    
    public static void main(String Fildz[])
    {
        ArbreBin2 mon_prenom = 
        new ArbreBin2("O", // Racine principale
            new ArbreBin2("T", null, // Sous Arbre Droit
                new ArbreBin2("I", null, null)), // Sous Sous Arbre Gauche 
                            
                            new ArbreBin2("E", // Sous arbre Gauche
                new ArbreBin2("N", null,null), // Sous Sous Arbre Droit
        new ArbreBin2("B",null,null)) // Sous Sous Arbre Gauche
        );
        mon_prenom.infixe() ;
        System.out.println() ;
        mon_prenom.prefixe() ;
        System.out.println();
        mon_prenom.postfixe() ;
    }
}

/* Le Dictionnaire *\
/*
 -----------------------------------------------------------
 | ArbreBinDico.java * * Created on 16 janvier 2005, 21:29  |
 | par  Fildz                                               |
 -----------------------------------------------------------
 */
public class CArbreBinDico {
    
    //- Les Variables de classe -\\
    protected CMot mot ; // Objet contenant le "mot" et sa "def"
    protected CArbreBinDico arbreGauche ; // Sous arbre gauche
    protected CArbreBinDico arbreDroit ; // Sous arbre droit   
    
    //- Le Constructeur -\\
    public CArbreBinDico(CMot m, CArbreBinDico D, CArbreBinDico G) {        
        mot = m ;
        arbreGauche = G ;
        arbreDroit = D ;        
    }
    
    //- Les Getters -\\
    public CMot getRacine() { return mot ; }
    
    public String getMot() { return mot.getMot() ; }
    public String getDef() { return mot.getDef() ; }
    public CArbreBinDico getSag() { return arbreGauche ; }
    public CArbreBinDico getSad() { return arbreDroit ; }
    
    //- Les Setters -\\
    public void setArbreGauche(CArbreBinDico G) { arbreGauche = G ; }
    public void setArbreDroit(CArbreBinDico D) { arbreDroit = D ; }
    public void setMot(CMot m) { mot = m ; }
    
    
    //- L'affichage Alphabetique == parcours Infixe() -\\
    public void infixe() {        
        if (arbreGauche != null)
            arbreGauche.infixe() ;
        if (mot != null) System.out.println( getMot() + " : "+ getDef() );
        if (arbreDroit != null)
            arbreDroit.infixe() ;    
    }
}
 
 
 /*  La Classe CMot */
 public class CMot {
    
    protected String mot ;
    protected String def ;
    
    public CMot(String m,String d) {
        mot = m;
        def = d ;
    }
    
    public String getMot() { return mot ; }
    public String getDef() { return def ; }       
}

/*  La Classe permettant de Géré le Dico */
public class CGereDico {
    
    public static void main(String[] args) {
        
        int choix ;
        // Création du dico, initialisé à vide (null)
        CArbreBinDico le_dico = new CArbreBinDico(null,null,null) ;
        
        System.out.println("Bienvenue dans le system de gestion du Dico :");
        
        do {
            
            System.out.println("Vous voulez,");
            System.out.println("1 - Voir le contenu du Dico");
            System.out.println("2 - Ajouter un Nouveau Mot");
            System.out.println("0 - Quitter");

            choix = Lire.i() ;
            
            
            switch(choix) {             
                case 1: le_dico.infixe(); break;
                case 2: ajouterMot(le_dico); break;                
            }      
            
        }
        while(choix!=0); // Tant que l'utilisateur ne veut pas quitter
    }
    
    
    // Les Fonctions \\
	
    public static void afficheDico(CArbreBinDico d) { d.infixe() ; }
    
    public static void ajouterMot(CArbreBinDico le_dico) 
    {
        System.out.println("Quel mot voulez vous ajouter?");
        String m = Lire.S() ;
        System.out.println("Quelle est sa définition ?");
        String d = Lire.S() ;
        
        
        CMot nouveau_mot = new CMot(m, d); // Création de l'objet CMot (mot + def)

            ajout(le_dico,nouveau_mot) ;
        
            System.out.println("Mot ajouter :" + nouveau_mot.getMot() + " : "+ nouveau_mot.getDef() ) ;
    }
    
    public static void ajout(CArbreBinDico arbre, CMot nouveau_mot)
    {
        
        if (arbre.getRacine() == null)
        {
            arbre.setMot( nouveau_mot ) ;
            arbre.setArbreGauche( new CArbreBinDico (null,null,null) ) ;
            arbre.setArbreDroit( new CArbreBinDico (null,null,null) ) ;
        }
        
        else if (arbre.getRacine().getMot().compareTo(nouveau_mot.getMot()) > 0)
            ajout(arbre.getSag() ,nouveau_mot);
        
        else if (arbre.getRacine().getMot().compareTo(nouveau_mot.getMot()) < 0)
            ajout(arbre.getSad() , nouveau_mot ) ;
        else 
            System.out.println("Mot déjà saisi !");
    }    
} 
