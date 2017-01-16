
public class Romain2Arabe {

    public static void main(String[] args) {
        String str="";
        int nb=3428;
        System.out.println( nb%5 );
        
        System.out.println( nb%10 );
        System.out.println( nb%100 - nb%10 );
        System.out.println( (nb - ((nb%10)+(nb%100-nb%10)))%1000 );
        System.out.println( nb-nb%1000 );
    
    }
    
}
