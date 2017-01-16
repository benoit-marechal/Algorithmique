/* * FileTableau.java * * Created on 11 décembre 2004, 09:40 *
 * @author  Fildz */
public class FileTableau  {
    protected Object elements[] ;
    protected int taille ;
    protected int tailleMax ;
    protected int tete ;
    protected int queue ;
    public Class ObjetType ;
    
    public FileTableau(int m,Class c) {
        
        tailleMax = m ;
        ObjetType = c ;
        elements = new Object[tailleMax] ;
        taille = 0 ;        
        tete = 0;
        queue = 0;
        
    }
    
    public void ajoutEnQueue(Object e) throws FilePleineException,ObjectTypeException
    {
        if (e.getClass() != ObjetType ) { System.out.println( "Class de e :"+ e.getClass() + " et ObjetType = "+ ObjetType ); throw new ObjectTypeException() ; }
        if (taille == tailleMax ) throw new FilePleineException() ;
        elements[queue] = e ;
        queue = (queue+1) % (tailleMax-1) ;
        taille++;       
    }
    
    public void suprEnTete( ) throws FileVideException 
    {
        if (estVide()) throw new FileVideException() ;
        elements[tete]=null;        
        tete = (tete+1) % (tailleMax-1) ;
        taille-- ;        
    }
    
    public boolean equals(File f)
    {
        FileTableau ff = (FileTableau) f ;
        if (ff.taille() != taille() ) return false ;
        int tetef = ff.tete ;
        
        for (int i  = tete ; i<tete+taille ; i++)
        {
            if ( elements[ i% (tailleMax - 1)]!= ff.elements[ tetef % (ff.tailleMax-1) ] )
                return false;
            tetef++;
        }
        return true;    
    }
    public Object tete() throws ObjectException{
        if (estVide() ) throw new ObjectException() ;
        return elements[tete] ;
    }
    
    public int taille() {
        return taille ;
    }
    public boolean estVide() {
        return (taille==0);
    }
    
    public void afficher() 
    {
        if (taille != 0)
        for(int i=tete ; i<tete+taille ; i++)
            System.out.println(   elements[ i % (tailleMax-1) ]   ) ;        
    }
}
