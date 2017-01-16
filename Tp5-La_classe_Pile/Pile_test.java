/* * Pile_test.java * * Created on 9 décembre 2004, 09: *
 * @author  Fildz */
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
