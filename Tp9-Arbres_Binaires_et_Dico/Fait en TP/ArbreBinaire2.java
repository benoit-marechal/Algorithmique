public class ArbreBinaire2 implements ArbreBinaireG {
    
    protected Mot etiquette;
    public ArbreBinaire2 sag;
    public ArbreBinaire2 sad;
    protected Class typedeselements;

    public ArbreBinaire2(Class type , Mot e , ArbreBinaire2 G , ArbreBinaire2 D) {
        typedeselements = type;
        etiquette = e;
        sag = G;
        sad = D;
    }
    
    public boolean appartient(Object s) {
       if ( this.etiquette == null ) return false;
       if ( etiquette.equals(s) ) return true;
       if ( sag != null && sag().appartient(s) ) return true;
       if ( sad != null && sad().appartient(s)) return true;
       return false;
    }
    
    /*public void infixe() {
        if ( sag != null )
            sag.infixe();
        if ( etiquette != null )
        System.out.print( etiquette + " " );
        if ( sad != null )
            sad.infixe();
    }
    */
    public void postfixe() {
        if ( sag != null )
            sag.postfixe();
        if ( sad != null )
            sad.postfixe();
        System.out.print( etiquette + " " );
    }
    public void infixe() {
        if ( sag != null )
            sag.infixe();
        if ( etiquette != null )
        System.out.println( etiquette.getMot() + " : " + etiquette.getDef()   );
        if ( sad != null )
            sad.infixe();
    }
    
    public void prefixe() {
        System.out.print( etiquette + " " );
        if ( sag != null )
            sag.prefixe();
        if ( sad != null )
            sad.prefixe();
    }
    
    public Object racine() { return etiquette; }
    
    public ArbreBinaireG sad() { return sad; }
    
    public ArbreBinaireG sag() { return sag; }
    
    public void setracine(Mot e) { etiquette = e ; }
    
}
