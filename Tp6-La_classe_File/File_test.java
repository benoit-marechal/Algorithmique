/* * File_test.java * * Created on 11 décembre 2004, 12:19 *
 * @author  Fildz */
public class File_test {
    public static void main(String args[]) 
    {
        FileTableau F1 =new FileTableau(4, java.lang.String.class ) ;
        FileTableau F2 =new FileTableau(4, java.lang.String.class ) ;
        
        FileChainer F3 = new FileChainer(4,  java.lang.String.class );
        FileChainer F4 = new FileChainer(4,  java.lang.String.class );
        
        try {
            F1.ajoutEnQueue("a");
            F1.ajoutEnQueue("b");
            F1.ajoutEnQueue("a");
            
            F2.ajoutEnQueue("a");
            F2.ajoutEnQueue("a");
            F2.ajoutEnQueue("a");
            F2.ajoutEnQueue("a");
            F2.afficher() ;
            System.out.println(F2.equals(F1)) ;
            
            System.out.println( "------- FileChainer ----------");
            F3.ajoutEnQueue("A");
            F3.ajoutEnQueue("B");
            F3.ajoutEnQueue("C");
            F3.afficher() ;
            
            F4.ajoutEnQueue("bA");
            F4.suprEnTete() ;
            F4.afficher()  ;
            F4.suprEnTete() ;
            F4.afficher() ;
            System.out.println( F4.equals(F3) ) ;
            
            
        }
        catch(FilePleineException e ) { }
        catch(ObjectTypeException e ) { }
        catch(FileVideException e ) { }
     //   catch(ObjectException e ) { }
        
    }
}
