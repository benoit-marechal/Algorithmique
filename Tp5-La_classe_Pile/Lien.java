						 La Pile 
/*  Created on 9 décembre 2004, 21:13 *
* @author  Fildz*/
	

	/*  Interface de la Pile*/
public interface Pile {
    public void empiler(Object e) throws PilePleineException,ErreurTypeException; // ajout en tete
    public void depiler() throws PileVideException; // supprime la tete
    public Object tete() throws ObjectException ;
    public boolean estVide() ; // verifie si la pile est Vide (taille == 0)
    public int taille(); // Renvoie la taille de la Pile ( return taille );
    public boolean equals(Pile p) ; // verifie si 2 Piles sont egales
    public void afficher(); // affiche le contenu de la Pile
}
	
/* Classes Lien */ 
public class Lien { // gestion du pointeur
    
    protected Lien Suivant ; // Le lien (pointeur) 
    
    public void suivant(Lien s) { Suivant = s ; } // set Lien
    public Lien suivant() {return Suivant ;} // renvoie le Lien
    
}

/* Classe Noeud */
public class Noeud extends Lien{
    protected Object valeur ; // Valeur de type non définie pour l'instant
       
    
    public Noeud(Object e) { valeur = e ;} // set Valeur
    public Object valeur() { return valeur ;} // get Valeur
    public Noeud noeudSuivant() { return (Noeud) suivant() ; } // renvoie le Noeud suivant ( et ceci grace seulement a un Lien)
    public void noeudSuivant(Noeud s) { suivant(s) ; } // set noeudSuivant = set Lien (grace un a objet Noeud !)
    
}

/* Classes Gestion des erreur de type ErreurTypeException*/
public class ErreurTypeException extends Exception{
    
   public ErreurTypeException() {
    System.out.println("ERROR 002 : Le type de l'objet a inseré dans la Pile n'est pas correct");
    }
    
}

/*   Classe Erreur de type objectException    */
public class ObjectException extends Exception {    
    public ObjectException() 
    {        System.out.println("ERROR 005 : ObjectException");  }    
}
/*  Classe Erreur de type PilePleineException */
public class PilePleineException extends Exception {
    
   public PilePleineException() {
        System.out.println("ERROR 001 : La Pile est PLEINE ! ");
    }    
}
/* Classe Erreur de type PileVide  */
class PileVideException extends Exception {    
    PileVideException() {
        System.out.println("ERROR 003 : La Pile est VIDE !");
    }
    
}


/*  PileChainer */
public class PileChainer implements Pile {
  
    protected Noeud tete ;      // la tete de la Pile 
    protected int taille;       // taille de la Pile
    protected int tailleMax ;   // taille maximal de la Pile
    protected Class objetType;  // type des element ("valeur") de la Pile
    
    
    public PileChainer(int t,Class c) 
    {
        tailleMax = t ;
        objetType = c ;
        tete = null ;
        taille = 0;
    }
        
        public void empiler(Object e) throws PilePleineException, ErreurTypeException 
        {
            if (e.getClass() != objetType) throw new ErreurTypeException();
            if (taille == tailleMax) throw new PilePleineException();
            
            Noeud tmp = new Noeud(e) ;
            tmp.noeudSuivant(tete);
            tete = tmp ;
            taille++ ;
            
        }


        public void depiler() throws PileVideException 
        {
            if ( estVide() ) throw new PileVideException() ;
            
            tete = tete.noeudSuivant() ;
            taille-- ;
        }


        public boolean estVide() {
            return (taille == 0);
        }

        public int taille() {
            return taille ;
        }

        public Object tete() throws ObjectException { 
        if ( taille == 0 ) throw  new ObjectException() ;    
            return tete.valeur(); 
        
        }
        public boolean equals(Pile p) 
        {
           if (p.taille() != taille() ) return false; 
           PileChainer pp =(PileChainer) p ;
           Noeud tmp1 = pp.tete ;
           Noeud tmp2 = tete ;
           
           for (int i = 0 ; i<taille() ; i++)
           {
              if  (tmp1.valeur() != tmp2.valeur()) return false;
              tmp1 = tmp1.noeudSuivant() ;
              tmp2 = tmp2.noeudSuivant() ;
                i++;   
           }
           return true ;
       
        }

        public void afficher()
        {
            Noeud T = tete ;
             for (int i =  0 ; i<taille() ; i++)
            {
                System.out.println(T.valeur()) ;
                T = T.noeudSuivant();
             }
            
        }

}

/*  PileTableau  */
public class PileTableau implements Pile {   
    protected Object[]elements; // pile d'elements de type a definir ds le constructeur
    protected int taille; // taille actuel de la pile
    protected int tailleMax ; // taille Maximum de la pile
    protected Class objetType ; // type des objet a mettre ds la pile
    
    
    public PileTableau(int t, Class c) {
        tailleMax = t ;        
        taille = 0;
        objetType = c ;
        elements = new Object[tailleMax] ;       
    }
    
        public void empiler(Object e) throws PilePleineException,ErreurTypeException
        {
            if ( taille == tailleMax) throw new PilePleineException() ;
            else if (e.getClass() != objetType) throw new ErreurTypeException() ;
            else elements[taille++] = e ;   
        }

        public void depiler() throws PileVideException 
        {
            if (taille == 0) throw new PileVideException() ;
            elements[taille--] = null ;
         }
        public Object tete() throws ObjectException { return elements[taille] ; }
        public boolean estVide()
        { return (taille==0) ; }

        public int taille()
        {  return taille ; }

        public void afficher() 
        {
            for (int i = 0 ; i<taille ; i++)
                System.out.println(elements[i] + " ");
        }

   public boolean equals(Pile p) 
    {      
    return true ;
   }        
  
}

/*  Exemple de Test de Pile */
public class Pile_test {
    
    public static void main(String[] args) {
    
    PileTableau P1 = new PileTableau(3, java.lang.String.class );
   try {    
    P1.empiler("coco");
    P1.empiler("lapine");
    P1.afficher() ;
    P1.depiler();
    P1.afficher();    
   }
   catch ( PilePleineException e) { }   
   catch (ErreurTypeException a ) {}  
   catch (PileVideException c) { } 

    PileChainer P2 = new PileChainer(4,  java.lang.String.class );
    PileChainer P3 = new PileChainer(4,  java.lang.String.class );
    System.out.println("---------  Pile 2 ----------");
    try {
        P2.empiler("hihi");
        P2.empiler("huhu");
        P2.empiler("koikoikoi");
        P2.afficher();
        
        P3.empiler("hihi");
        P3.empiler("huhu");
        P3.empiler("koikoikoi");
        System.out.println(P2.equals(P3) );
        P3.empiler("ahhhh");
        P2.depiler();
        P2.afficher();
        System.out.println(P3.tete() );
    }    
    catch ( PilePleineException e) { }   
    catch (ErreurTypeException a ) {}
    catch (ObjectException a ) {}
    catch (PileVideException c) { System.out.println("et oui ...");}     
     } 
    }


