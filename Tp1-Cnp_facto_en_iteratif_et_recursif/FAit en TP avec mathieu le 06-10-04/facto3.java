
public class facto3 {
	public static void main ( String args[] ) {

		int fac,n;
		//System.out.println("entrez n");
		n = 5;
		fac = facto(n);
		System.out.println("= " + fac);
	}
	
	public static int facto(int n ){
            
          if ( n > 1 ) {
              return n*facto(n-1); 
          }
            return 1;
        }
}