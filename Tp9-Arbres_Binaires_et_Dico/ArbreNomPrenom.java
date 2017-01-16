/* * ArbreNomPrenom.java * * Created on 16 janvier 2005, 20:38*
 * @author  Fildz */
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
        
        
        System.out.println("\nInfixe : ") ;
        mon_prenom.infixe() ;
        System.out.println("\nPreFixe : ") ;
        mon_prenom.prefixe() ;
        System.out.println("\nPostFixe : ");
        mon_prenom.postfixe() ;
        
        
    }
}
