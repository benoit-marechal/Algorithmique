public class ArbreDico {
    public static void main(String[] args) {
        
        String mot = "";
        String def= "";
        Mot m;
        ArbreBinaire2 dico = new ArbreBinaire2( Object.class , null ,  null , null );
        while ( !mot.equals("-1") ) {
            
            System.out.println("Entrez un mot dans le dico");
            mot = Lire.S();
            System.out.println("Entrez sa définition");
            def = Lire.S();
            m = new Mot( mot , def );
            ajoutermot( dico , m );
        }
        dico.infixe();
        System.out.println();
        
    }
 
    public static void ajoutermot( ArbreBinaire2 arbre , Mot mot ) {
        
        if ( arbre.racine() == null ) {
            arbre.setracine( mot );
            arbre.sag = new ArbreBinaire2( Mot.class , null ,  null , null );
            arbre.sad = new ArbreBinaire2( Mot.class , null ,  null , null );
        }
        
        else {
            Mot tmp = (Mot)arbre.racine();
            String eti = tmp.getMot();
            if ( eti.compareTo( mot.getMot() ) > 0 )
                ajoutermot( (ArbreBinaire2)arbre.sag() , mot );
            else if ( eti.compareTo( mot.getMot() ) < 0 )
                ajoutermot( (ArbreBinaire2)arbre.sad() , mot );
            else 
                System.out.println("Le mot existe deja dans le dico");
        }
            
        
        
    }
    
}
