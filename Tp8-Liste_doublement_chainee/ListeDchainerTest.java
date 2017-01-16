/* * ListeDchainerTest.java * * Created on 12 janvier 2005, 16:11*
 * @author  Fildz */
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
