/* * ListeChainer.java * * Created on 15 décembre 2004, 21:14
 * @author  Fildz */
public class ListeChainer {
    
    protected int taille ;
    protected Noeud tete ;
    protected Class ObjetType ;
    
    public ListeChainer(Class c) {
        ObjetType = c ;
        tete = null ;
        taille = 0 ;        
    }
    
    
    public void ajouter(int n,Object e) throws RangInvalidException 
    {
        if (n>taille) throw new RangInvalidException("Ajouter :Le rend est sup a la taille");
        
        Noeud tmp = new Noeud(e);
        if (n==0) {
            tmp.noeudSuivant(tete);
            tete = tmp ;
        }
        else {
        Noeud tmp2 = tete ;
            for(int i = 1 ; i<n ; i++)
                tmp2 = tmp2.noeudSuivant() ;
        
            if(tmp2.noeudSuivant() != null)
                tmp.noeudSuivant(tmp2.noeudSuivant());
        
            tmp2.noeudSuivant(tmp);
        
        
        }
            taille++;
    }
    
    public Object terme(int r) throws RangInvalidException
    {
        if (r > taille-1 || r<0) throw new RangInvalidException("Terme : Indice invalid");
        
        Noeud tmp = tete ;
        for(int i=1;i<=r;i++)
            tmp = tmp.noeudSuivant();
        
        return tmp ;       
        
    }
    
    public void supprimer(int r) throws RangInvalidException
    {
        if ( (r>taille-1) || (r<0)) throw new RangInvalidException("Suppr : Indice invalid");
        if (r==0) tete = tete.noeudSuivant() ;
        else {
            Noeud tmp = tete ;
            for (int i=0;i<r-1;i++)
                tmp = tmp.noeudSuivant();
            
             if (r==taille-1) tmp.noeudSuivant(null);
             else tmp.noeudSuivant ( tmp.noeudSuivant().noeudSuivant() ) ;        
        }
        
        
        taille--;   
        
    }
    
    public int longueur() { return taille ; }
   
    public void afficher() {   
        if(tete != null) {
            Noeud tmp = tete ;
                for (int i=0 ; i<taille;i++)
                {
                 System.out.println( tmp.valeur() ) ;
                 tmp = tmp.noeudSuivant();            
                }
        }
        
    }
    
}
