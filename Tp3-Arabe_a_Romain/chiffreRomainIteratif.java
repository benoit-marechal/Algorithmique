
public class chiffreRomainIteratif {
    

    public static void main(String[] args) {
        String str = "MCMXCIX";
        int ind=0, somme = 0;
        while ( ind < str.length()-1 ) {
            if ( convert(str.charAt(ind)) >= convert(str.charAt(ind+1)) ) {
             somme += convert(str.charAt(ind));
             ind++;
            }
            else {
                somme += convert(str.charAt(ind+1))-convert(str.charAt(ind));
                ind = ind + 2 ;
            }
                
                
         }
        if ( str.length()-ind == 1 )
            somme += convert( str.charAt(str.length()-1));    
        System.out.println(somme);
    }
    public static int convert( char c ) {
        switch( c ) {
            
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }
}
