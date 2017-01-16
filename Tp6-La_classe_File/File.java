	//					La File
/* * File.java * * Created on 11 décembre 2004, 09:27*
 * @author  Fildz */
public interface File  {
    public void ajoutEnQueue(Object e) throws FilePleineException,ObjectTypeException ; // Ajoute un objet en Queue
    public void suprEnTete() throws FileVideException ; // Supprime l'objet en Tete
    public int taille() ; // Renvoie la taille de la File
    public Object tete()throws ObjectException; // Renvoie la tete de la File
    public boolean estVide() ; // verifie si la File est Vide  
    public void afficher(); // affiche le contenu de la Pile
}
