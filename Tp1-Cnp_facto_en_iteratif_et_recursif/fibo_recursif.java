/* * fibo_recursif.java * Created on 10 octobre 2004, 09:42 *
 * @author  Fildz */
/* TP 1 - ex2 Calcul de la suite de fibo de maniere recursive*/
public class fibo_recursif {
    
    public static void main(String[] FiLdZ) {
        
        int n;
        int fib ;
         
        
        System.out.print("Donnez n : ");
            n=Lire.i();
            
        fib=fibo(n);
        System.out.println("Fibo("+n+") = "+fib);
    }
    
    public static int fibo(int n)
    {
        if(n==0) return 0;
        else if (n==1) return 1 ;
        else return fibo(n-1) + fibo(n-2);
    }
    
}
