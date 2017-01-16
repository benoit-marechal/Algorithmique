						LA Liste Doublement Chainer
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
    public Lien Precedent ;
    
    public Lien suivant() { return Suivant ; }
    public void suivant(Lien s) { Suivant = s ;  }
   
    public Lien precedent() { return Suivant ; }
    public void precedent(Lien s) { Suivant = s ;  }
    
}

public class Noeud extends Lien {
    protected Object valeur ;
    
    public Noeud(Object v) { valeur = v ;} // set valeur (ds le constructeur de Noeud
    public Object valeur() { return valeur ; } // get Valeur
    public Noeud noeudSuivant() { return (Noeud) suivant() ; } // get le Noeud suivant par un lien !
    public void noeudSuivant(Noeud n) { suivant(n); } // set le Lien suivant par un Noeud !
 
    public Noeud noeudPrecedent() { return (Noeud) precedent() ; } // get le Noeud suivant par un lien !
    public void noeudPrecedent(Noeud n) { precedent(n); } // set le Lien suivant par un Noeud !
    
    
}

public class RangInvalidException extends Exception {
    
    public RangInvalidException(String mess) {
        System.out.println(mess);
    }    
}

/*   La Classe de la Liste Doublement Chainer     */
public class ListeDlmtChainer implements Liste {
    
    protected Noeud tete ;
    protected int taille ;
    protected Class ObjetType ;
    
    public ListeDlmtChainer(Class c) {
        ObjetType = c ;
        tete = null ;
        taille = 0 ;
    }
    
    public void ajouter(int r , Object e) throws RangInvalidException
    {
        
        if ( e.getClass() != ObjetType ) throw new RangInvalidException("Mauvais type");
        if ( r<0 || r>taille) throw new RangInvalidException("Indice Out Of Bounds");
        
        if (taille == 0) { tete = new Noeud(e) ; } // 1 ier ajout 
        if (r==0) // on ajoute en tete
        {
            Noeud tmp = new Noeud(e) ;
            tmp.noeudSuivant(tete);            
            tete.noeudPrecedent(tmp) ;            
            tete = tmp ;            
        }
            
        else if (r==taille)
        {
           Noeud tmp1 = new Noeud(e) ;
           Noeud tmp2 = tete ;
           
           for(int i=1;i<r;i++)
               tmp2 = tmp2.noeudSuivant();
           
           tmp1.noeudPrecedent(tmp2);
           tmp2.noeudSuivant(tmp1);
            
        }
        else 
        {
            Noeud tmp1 = new Noeud(e);
            Noeud tmp2 = tete ;
            
            for(int i=1;i<r;i++)
                tmp2 = tmp2.noeudSuivant() ;
            
            Noeud tmp3 = tmp2.noeudSuivant() ;
            
            tmp2.noeudSuivant(tmp1);
            tmp1.noeudPrecedent(tmp2);
                        
            tmp3.noeudPrecedent(tmp1);
            tmp1.noeudSuivant(tmp3);            
        }
        taille++ ;
    }
    
    public void supprimer(int r) throws RangInvalidException
    {
        if (r<0 || r>taille-1) throw new RangInvalidException("Indice OutOf Bounds") ;
        
        if (estVide() )  throw new RangInvalidException("La Liste est deja vide ! ") ;
        
        if (r==0) // on veut supprimer en tete
        { tete = tete.noeudSuivant() ; }
        
        else if (r==taille-1) // on veut supprimer en queue
        {
            Noeud tmp = tete ;            
            for(int i =1 ; i<r ; i++)
                tmp = tmp.noeudSuivant() ;            
            tmp.noeudSuivant(null);   
        }
        
        else { // on veut supprimer en milieu de liste 
            Noeud tmp1 = tete ;
            for(int i=1 ; i<r  ; i++)
                tmp1 = tmp1.noeudSuivant() ;
            
            Noeud tmp2 = tmp1.noeudSuivant().noeudSuivant();
            
            tmp1.noeudSuivant(tmp2) ;
            tmp2.noeudPrecedent(tmp1);
        }
        taille-- ;
    }
    
    public int longueur () { return taille ; }
    
    public boolean estVide() { return (taille==0) ; }
    
    public Object terme(int r) throws RangInvalidException
    {
        if (r<0 || r>taille-1) throw new RangInvalidException("Cet indice n'existe pas");
    
        Noeud tmp = tete ;
        
        for(int i =1 ; i<=r ; i++)
            tmp = tmp.noeudSuivant() ;
        
        return tmp.valeur() ;             
    }
    
    public void afficher() 
    {
        
        for(int i=0 ; i<taille ; i++)
        { try{
            System.out.println( terme(i) );
          }
          catch(RangInvalidException e) {}
        }
    }    
}
/*   Test de la Liste Doublement Chainer    */
public class ListeDchainerTest {
  
    public static void main(String[] args) {
    
        ListeDlmtChainer L1 = new  ListeDlmtChainer(java.lang.String.class) ;
     try{
        L1.ajouter(0,"Hum") ;
        L1.ajouter(1, "Coco");
        L1.ajouter(2, "Lapine");
        //L1.supprimer(2);
        System.out.println(L1.longueur() );
        L1.afficher() ;        
     }
     catch(RangInvalidException e) { }
        
        
    
    }
    
    
}
