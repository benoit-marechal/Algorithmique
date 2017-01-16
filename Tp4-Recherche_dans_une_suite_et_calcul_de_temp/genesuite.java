
public class genesuite {
    public int[]suite;
    public int nbelement;
    
    public genesuite( int nbelement) {
        this.nbelement = nbelement;
        suite = new int[nbelement];
        remplir();
        affiche();
    }
    
    public void remplir() {
        int nb = 1;
        suite[0] = nb;
        for ( int i = 1 ; i < nbelement ; i ++ ) 
            suite[i] = suite[i-1] + (int)Math.floor((Math.random()*50)+1);       
    }
   public void affiche(){
        for ( int i = 0 ; i < nbelement ; i ++ ) 
            System.out.print( suite[i] +" | " );
        System.out.println();
    }
        
}
