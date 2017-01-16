/* * ListeTest.java * * Created on 15 décembre 2004, 22:08
 * @author  Fildz */
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
