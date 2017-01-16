public class facto2{

	public static void main ( String args[] ) {

		int fac,n;
		//System.out.println("entrez n");
		n = 5;
		fac = facto(n,n-1);
		System.out.println("= " + fac);
	}
	
	public static int facto(int n1 ,int n2 ){
       
          // System.out.println( n1 );
		if ( n2 > 1 ) {
			n1 = n1*n2;
			return facto( n1 , n2-1 ); 
		}

		return n1;
	}
}