
public class Arabe2Rom1 {
    

    public static void main(String[] args) {
        System.out.println( conv( 1499 , "") );
    }
    
    public static String conv( int nb , String ch ) {
        char[] nbR = new char[3];
        if ( nb == 0 ) {
            return ch;
        }
        else {
            if ( nb / 1000 > 0 ) {
                for (int i = 1; i <= (int)nb/1000 ; i++ ) 
                    ch += 'M';
                return conv( nb%1000 , ch );
            }
            else if ( nb/100 > 0 ){
                nbR[0] = 'C';
                nbR[1] = 'D';
                nbR[2] = 'M';
                ch = addi( ch , (int)nb/100 , nbR );
                return conv( nb%100 , ch );
            }
            else if ( nb / 10 > 0 ) {
                nbR[0] = 'X';
                nbR[1] = 'L';
                nbR[2] = 'C';
                ch = addi( ch , (int)nb/10 , nbR );
                return conv( nb%10 , ch );
            }
            else {
                nbR[0] = 'I';
                nbR[1] = 'V';
                nbR[2] = 'X';
                ch = addi( ch , (int)nb , nbR );
                return conv( 0 , ch );
            }
            
        }
        
    }
    public static String addi (String ch , int n , char[] tab ) {
        if ( n <= 3 ) {
            for ( int i = 1 ; i <= n ; i ++ ) 
                ch+=tab[0];
        }
        else if ( n == 4 ) {
            ch+= tab[0] ;
            ch+=tab[1];
        }
        else if ( n == 5 )
            ch+= tab[1];
        else if ( n<= 8 ) {
            ch+= tab[1];
            for ( int i = 1 ; i <= n-5 ; i ++ )
                ch+=tab[0];
        }
        else if ( n == 9 ){
            ch+=tab[0];
            ch+=tab[2];
        }
        
        return ch;
    }
}
