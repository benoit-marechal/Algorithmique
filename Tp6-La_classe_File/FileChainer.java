/* * FileChainer.java * * Created on 11 décembre 2004, 13:03 *
 * @author  Fildz */
public class FileChainer implements File {
    
   protected Noeud tete ;
   protected Noeud queue;
   protected int taille ;
   protected int tailleMax ;
   protected Class ObjetType ;
   
    
    public FileChainer(int t,Class  c) {
        tailleMax = t ;
        ObjetType = c ;
        taille = 0 ;
        tete = null ;             
    }
    
    public void ajoutEnQueue(Object e) throws ObjectTypeException,FilePleineException
    {
     if (e.getClass() != ObjetType ) throw new ObjectTypeException();
     if (taille == tailleMax ) throw new FilePleineException();
     
     Noeud tmp = new Noeud(e);
     if (taille == 0){ tete = new Noeud (e); queue = tete ;}
     else {
     queue.noeudSuivant(tmp) ;
     queue = tmp ; 
     }
     taille++ ;
    }
    
    public void suprEnTete() throws FileVideException
    {
        if (estVide() ) throw new FileVideException() ;
        tete = tete.noeudSuivant();
        taille-- ;
    }
    
    
    public boolean equals(File f) 
    {
        FileChainer ff =(FileChainer) f ;
       if (taille() != ff.taille() ) return false ;
        Noeud tmp1 = tete;
        Noeud tmp2 = ff.tete;
        for (int i=0;i<taille() ; i++)
        {
            if ( tmp1.valeur() != tmp2.valeur() ) return false ;
            tmp1 = tmp1.noeudSuivant();
            tmp2 = tmp2.noeudSuivant();           
        }
        return true;       
    }
    public int taille() {
        return taille ; 
    }
    
    public boolean estVide() { return (taille == 0 ); }
    public Object tete() { return tete.valeur() ; }
    
    public void afficher() {
        Noeud tmp = tete ;
        for (int i = 0 ; i< taille() ; i++)
        { 
        System.out.println(tmp.valeur() );
        tmp = tmp.noeudSuivant() ;
        }
    }
}
