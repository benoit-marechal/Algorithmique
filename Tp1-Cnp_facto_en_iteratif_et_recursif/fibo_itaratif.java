/* * fibo_itaratif.java * Created on 10 octobre 2004, 09:21
 * @author  Fildz */
/* TP 1 - ex2 calcul de la suite de fibo de maniere itarative*/
public class fibo_itaratif {
    public static void main(String[] args) {
        
        int n;
        int vieux=0,nouv=1,tmp;
        
        
        System.out.print("Donnez n : ");
            n=Lire.i();
            
            
        for(int i=1;i<n;i++)
        {
           tmp=nouv;
           nouv+=vieux;
           vieux=tmp;
        }
     
            System.out.println("Fibo("+n+") = "+nouv );
    }
    
}
