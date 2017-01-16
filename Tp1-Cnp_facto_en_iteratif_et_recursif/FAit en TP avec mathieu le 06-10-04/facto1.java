public class facto1 {
	public static void main ( String args[]){
		int n,fac=1;
		//System.out.println("Entrez n");
		n = 5;
		if ( n >= 1 ) {
			while ( n != 0 ) 
				fac = fac * n-- ;
			System.out.println( "= " + fac );
				}
		else
			System.out.println("mauvais nb");
	}
}