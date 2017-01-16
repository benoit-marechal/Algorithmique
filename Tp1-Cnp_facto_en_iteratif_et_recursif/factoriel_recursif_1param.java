/* factoriel_recursif_2param.java * Created on 9 octobre 2004, 19:09
 * @author  Fildz */
/* TP 1 - ex1 Calcul d'une factorielle de maniere récursive avec 1 parametres dans la fonction */
public class factoriel_recursif_1param {
    
    public static void main(String FiLdZ[])
    {
        int n;
        int facto;
        
            System.out.println("Donnez n:");
                n=Lire.i();
                
            facto = calculFacto(n);
            
            System.out.println("--> "+n+"! = "+facto);
            
    }
    
    public static int calculFacto(int n)
    {
        if (n<2) { return 1 ;}
        else return n*calculFacto(n-1);
    
    }
    
}
