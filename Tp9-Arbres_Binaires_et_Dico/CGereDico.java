/* * CGereDico.java * * Created on 16 janvier 2005, 21:49*
 * @author  Fildz */
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
        
     /*   if (le_dico.getRacine() == null) 
        {
            le_dico.setMot(nouveau_mot) ;

            le_dico.setArbreGauche( new CArbreBinDico(null,null,null) );
            le_dico.setArbreDroit( new CArbreBinDico(null,null,null) );            
        }
        else */
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
