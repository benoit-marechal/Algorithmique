/* * factoriel_iteratif.java * Created on 9 octobre 2004, 19:01 *
 * @author  Fildz */
/* TP 1 - ex1 Calcul d'une factorielle de maniere itérative */
public class factoriel_iteratif {
    public static void main(String FiLdZ[])
    {
        int n ; // valeur de la factoriel a calculé
        int facto = 1; // resultat du calcul de la factoriel (initialisation à 1)
        
        // Saisi de la valeur dont on veut la factorielle
        System.out.print("Donnez n : ");
        n=Lire.i();
        
        // boucle du calcul 
        for ( int i = 1 ; i<= n ; i++)
            facto *= i ;
        
        // affichage du résultat
        System.out.println("--> "+n+"! = "+facto);
    }
    
}
