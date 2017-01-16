/* * PileChainer.java * * Created on 9 décembre 2004, 20:46 *
 * @author  Fildz */
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
