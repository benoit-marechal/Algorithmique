/*
 -----------------------------------------------------------
 | ArbreBinDico.java * * Created on 16 janvier 2005, 21:29  |
 | par  Fildz                                               |
 -----------------------------------------------------------
 */
public class CArbreBinDico {
    
    //- Les Variables de classe -\\
    protected CMot mot ; // Objet contenant le "mot" et sa "def"
    protected CArbreBinDico arbreGauche ; // Sous arbre gauche
    protected CArbreBinDico arbreDroit ; // Sous arbre droit   
    
    //- Le Constructeur -\\
    public CArbreBinDico(CMot m, CArbreBinDico D, CArbreBinDico G) {        
        mot = m ;
        arbreGauche = G ;
        arbreDroit = D ;        
    }
    
    //- Les Getters -\\
    public CMot getRacine() { return mot ; }
    
    public String getMot() { return mot.getMot() ; }
    public String getDef() { return mot.getDef() ; }
    public CArbreBinDico getSag() { return arbreGauche ; }
    public CArbreBinDico getSad() { return arbreDroit ; }
    
    //- Les Setters -\\
    public void setArbreGauche(CArbreBinDico G) { arbreGauche = G ; }
    public void setArbreDroit(CArbreBinDico D) { arbreDroit = D ; }
    public void setMot(CMot m) { mot = m ; }
    
    
    //- L'affichage Alphabetique == parcours Infixe() -\\
    public void infixe() {        
        if (arbreGauche != null)
            arbreGauche.infixe() ;
        if (mot != null) System.out.println( getMot() + " : "+ getDef() );
        if (arbreDroit != null)
            arbreDroit.infixe() ;    
    }
    
    
    
    
}
