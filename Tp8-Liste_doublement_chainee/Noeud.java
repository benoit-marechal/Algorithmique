/* * Noeud.java * * Created on 11 décembre 2004, 13:06
 * @author  Fildz */
public class Noeud extends Lien {
    protected Object valeur ;
    
    public Noeud(Object v) { valeur = v ;} // set valeur (ds le constructeur de Noeud
    public Object valeur() { return valeur ; } // get Valeur
    public Noeud noeudSuivant() { return (Noeud) suivant() ; } // get le Noeud suivant par un lien !
    public void noeudSuivant(Noeud n) { suivant(n); } // set le Lien suivant par un Noeud !
 
    public Noeud noeudPrecedent() { return (Noeud) precedent() ; } // get le Noeud suivant par un lien !
    public void noeudPrecedent(Noeud n) { precedent(n); } // set le Lien suivant par un Noeud !
    
    
}
