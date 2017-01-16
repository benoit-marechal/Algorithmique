/* * Lien.java * * Created on 11 décembre 2004, 13:04 *
 * @author  Fildz */
public class Lien {
    public Lien Suivant ;
    public Lien Precedent ;
    
    public Lien suivant() { return Suivant ; }
    public void suivant(Lien s) { Suivant = s ;  }
   
    public Lien precedent() { return Suivant ; }
    public void precedent(Lien s) { Suivant = s ;  }
    
}
