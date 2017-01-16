/* * PileTableau.java * * Created on 9 décembre 2004, 08:58 *
 * @author  Fildz */
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
