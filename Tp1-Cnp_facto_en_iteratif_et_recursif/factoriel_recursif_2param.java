/* factoriel_recursif_2param.java * Created on 9 octobre 2004, 19:09
 * @author  Fildz */
/* TP 1 - ex1 Calcul d'une factorielle de maniere récursive avec 2 parametres dans la fonction */
public class factoriel_recursif_2param {
    public static void main(String FiLdZ[])
    {
        int n1,n2;
        int facto ;
        
        System.out.print("Donnez n :");
            n1=Lire.i();
            
        facto = calculFacto(n1,n1-1) ;
        System.out.println(facto);
        
    }
    
    public static int calculFacto(int n1,int n2) 
    {
        if(n2 < 2) { return n1 ; }
        else 
        {
            n1 = n1 * n2 ; 
            return calculFacto(n1,n2-1) ;
        }

    }
}
