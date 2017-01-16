						La Liste
/* * Liste.java * Created on 15 décembre 2004, 20:59
 * @author  Fildz */
public interface Liste { // Interface
    
    public void ajouter(int n,Object e) throws RangInvalidException ;
    public Object terme(int r) throws RangInvalidException ;
    public void supprimer(int r) throws RangInvalidException ;
    public int longueur() ;
    public void afficher() ;
    
}

public class Lien {
    public Lien Suivant ;
    
    public Lien suivant() { return Suivant ; }
    public void suivant(Lien s) { Suivant = s ;  }
    
}

public class Noeud extends Lien {
    protected Object valeur ;
    
    public Noeud(Object v) { valeur = v ;} // set valeur (ds le constructeur de Noeud
    public Object valeur() { return valeur ; } // get Valeur
    public Noeud noeudSuivant() { return (Noeud) suivant() ; } // get le Noeud suivant par un lien !
    public void noeudSuivant(Noeud n) { suivant(n); } // set le Lien suivant par un Noeud !
}

public class RangInvalidException extends Exception {    
    public RangInvalidException(String mess) {
        System.out.println(mess);
    }    
}

/*  La Liste Chainer  */
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

/*   Test de la Liste Chainer */

public class ListeTest {    
    public static void main(String[] args) {
        
        ListeChainer L1 = new ListeChainer(java.lang.String.class);
        try{
        L1.ajouter(0,"hum");
        L1.ajouter(1,"coco");
        L1.ajouter(2,"lapine");
        //System.out.println( L1.longueur() ) ;
        L1.afficher();
        L1.supprimer(1);
        L1.afficher();
        }
        catch(RangInvalidException r) {   }       
    }    
}

