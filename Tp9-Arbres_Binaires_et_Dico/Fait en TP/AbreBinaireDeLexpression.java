public class AbreBinaireDeLexpression {
    
    private ArbreBinaireG arbre;

    public AbreBinaireDeLexpression() {
        arbre = new ArbreBinaire2( String.class , "M" , 
                    new ArbreBinaire2( String.class , "a" ,
                        new ArbreBinaire2( String.class , "t" , 
                            new ArbreBinaire2( String.class , "h" , 
                                new ArbreBinaire2( String.class , "i" , null , null ) , 
                            new ArbreBinaire2( String.class , "e" , null , null )), 
                        new ArbreBinaire2( String.class , "u" , null , null ) ) , 
                    new ArbreBinaire2( String.class , " " , null , null ) ) , 
                    new ArbreBinaire2( String.class , "B" , 
                        new ArbreBinaire2( String.class , "o" , 
                            new ArbreBinaire2( String.class , "n" , 
                                new ArbreBinaire2( String.class , "i" , null , null ) , 
                            new ArbreBinaire2( String.class , "n" , null , null )) , 
                        null ) , null 
                    ) 
                 );
                    
                    
                    
                    
                    
        System.out.print( "Infixe : ");
        arbre.infixe();
        System.out.println();
        
        System.out.print( "Prefixe : ");
        arbre.prefixe();
        System.out.println();
        
        System.out.print( "Postfixe : ");
        arbre.postfixe();
        System.out.println();
        
        System.out.println( arbre.appartient( "i" ) );
    }
    
    
    public static void main( String[] Args ) {
        AbreBinaireDeLexpression a = new AbreBinaireDeLexpression();
    }
    
}
