/* * Noeud.java * * Created on 9 décembre 2004, 21:20
* @author  Fildz */
public class Noeud extends Lien{
    protected Object valeur ; // Valeur de type non définie pour l'instant
       
    
    public Noeud(Object e) { valeur = e ;} // set Valeur
    public Object valeur() { return valeur ;} // get Valeur
    public Noeud noeudSuivant() { return (Noeud) suivant() ; } // renvoie le Noeud suivant ( et ceci grace seulement a un Lien)
    public void noeudSuivant(Noeud s) { suivant(s) ; } // set noeudSuivant = set Lien (grace un a objet Noeud !)
    
}
