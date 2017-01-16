
public class rechintervalle {
    
    public genesuite suitee  ;
    
    public rechintervalle(){
    System.out.println( "Entrez le nb d'element de la suite : ");
        int n = Lire.i();
        
        suitee = new genesuite(n);
        
        System.out.println("Entrez l'element que vous voulez rechercher : ");
        int b = Lire.i();
        
        //methode 1
        System.out.println( methode1(b , suitee.suite ) );
        System.out.println( methode2(0 ,b , suitee.suite , 0 , suitee.nbelement ) );
    }


    
    public int methode1 (int b , int[] suite){ // recherche itérative
        int cpt=0;
        for ( int i = 0 ; i < suite.length ; i++){
            cpt++;
            if ( b < suite[i] ){
                 System.out.println(" nb iteration de la methode 1 : "+ cpt);
                return i-1;}
        }
        System.out.println(" nb iteration de la methode 1 : "+ cpt);
        return -1;
    }
    public int methode2 (int cpt ,int b , int[] suite , int ind1 , int ind2){ // recherche dichotomique
              cpt++;
            if ( ind2 - ind1 <= 1 ){
                System.out.println("nb d'apel de la fct pr la methode2 : " + cpt );
                return ind1;
            }
              int indm = ind1 + (int)(( ind2-ind1) / 2 );
              if ( b <= suite[indm] )
                  return methode2(cpt,  b , suite , ind1 , indm );
              
              return methode2(cpt ,  b , suite , indm , ind2 );
    
    }
    
    
        public static void main(String[] args) {
            
            rechintervalle obj = new rechintervalle() ;
            
        
    }
}
