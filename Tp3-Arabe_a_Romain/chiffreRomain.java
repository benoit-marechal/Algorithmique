
public class chiffreRomain {
    

    public static void main(String[] args) {
            String str = "MMCCCXLIX";
            System.out.println( arabe(str , 0 ) );
    
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
    public static int arabe(String rom , int somme ) {
        if ( rom.length() > 1 ) {
                if ( convert(rom.charAt(0)) >= convert(rom.charAt(1)) ) {
                    somme += convert(rom.charAt(0));
                    return arabe( rom.substring(1,rom.length() ) , somme );
                }
                else {
                    somme += convert(rom.charAt(1)) - convert(rom.charAt(0)) ;
                    return arabe( rom.substring(2,rom.length()) , somme );
                }
          }
        else if ( rom.equals("") ) 
            return somme ;
        
        return somme+convert(rom.charAt(0));
        }
    
}
