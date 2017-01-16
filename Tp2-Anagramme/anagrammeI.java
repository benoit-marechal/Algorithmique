/* * anagrammeI.java * Created on 14 octobre 2004, 14:58 *
 * @author  Fildz */
/* On doit vérifier si 2 chaines sont anagramme (cad composé par les meme lettre strictement)*/
public class anagrammeI {
    
    public static void main(String[] FiLdZ) 
    {
        String ch1 = "benoit" ;
        String ch2 = "toineb" ;
        
        boolean anagramme = false ;
        int j = 0;
        
        for(int i = 0 ; i < ch1.length() ; i++)
        {
            do
            {
                
                
               
                if ( ch1.charAt(i) == ch2.charAt(j) ) anagramme = true;;
                 j++;
                
            }
            while( (!anagramme) ( j < ch2.length()-1 ) ) ;
        }
        
    }
    
}
