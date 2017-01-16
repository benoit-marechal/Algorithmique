
public class cnp {

 public static int cnk(int n,int k)
 { if (n==0 || k==0 || n==k) return 1;
   else return (cnk(n-1,k) + cnk(n-1,k-1));
 }

 public static void main (String fildz[])
 { 
  int n,k;
  System.out.println("Entrez n");
  n=Lire.i(); 
  System.out.println("Entrez k");
  k=Lire.i(); 
  System.out.println("resultat: "+cnk(n,k));
 }

}
