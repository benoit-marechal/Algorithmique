/* * Pile.java * * Created on 8 décembre 2004, 22:33
 * @author  Fildz */

public interface Pile {
    public void empiler(Object e) throws PilePleineException,ErreurTypeException; // ajout en tete
    public void depiler() throws PileVideException; // supprime la tete
    public Object tete() throws ObjectException ;
    public boolean estVide() ; // verifie si la pile est Vide (taille == 0)
    public int taille(); // Renvoie la taille de la Pile ( return taille );
    public boolean equals(Pile p) ; // verifie si 2 Piles sont egales
    public void afficher(); // affiche le contenu de la Pile
}


