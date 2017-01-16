/* * ArbreBin2.java * * Created on 13 janvier 2005, 21:29*
 * @author  Fildz */
public class ArbreBin2 implements ArbreBinaireG {
    ArbreBin2 arbreGauche ;
    ArbreBin2 arbreDroit ;
    //Class typeDesElements ;
    Object Etiquette ;
    
    
    public ArbreBin2( Object E, ArbreBin2 D, ArbreBin2 G ) {
       // typeDesElements = type ;
        Etiquette = E ;
        arbreGauche = G ;
        arbreDroit = D; 
    }
       
    public ArbreBinaireG ArbreDroit() { return arbreDroit ; }
    
    public ArbreBinaireG ArbreGauche() { return arbreGauche ; }
    
    public boolean appartient(Object s) {
    
        if (Etiquette == null) return false ;
        if (Etiquette.equals(s)) return true ; // on considere donc que Etiquette est Forcement un String
        if (arbreGauche != null && ArbreGauche().appartient(s)) return true;
        if (arbreDroit != null && ArbreDroit().appartient(s)) return true;
        return false ;
        
    }
    
    public void infixe() {
        
        if (arbreGauche != null)
            arbreGauche.infixe() ;
        System.out.print(Etiquette + " ");
        if (arbreDroit != null)
            arbreDroit.infixe() ;
    
    }
    
    public void postfixe() {
        if (arbreGauche != null)
            arbreGauche.postfixe();
        if (arbreDroit != null)
            arbreDroit.postfixe();
        System.out.print(Etiquette + " ");                
    }
    
    public void prefixe() {
        System.out.print(Etiquette + " ");
        if (arbreGauche != null)
            arbreGauche.prefixe();
        if (arbreDroit != null)
            arbreDroit.prefixe() ;
    }
    
    public Object racine() { return Etiquette ; }
    
    
}
