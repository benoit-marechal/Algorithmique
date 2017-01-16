/* * anagrammeR2.java Created on 14 octobre 2004, 14:35*
 * @author  Fildz */
public class anagrammeR2 {    
    public static void main(String[] FiLdZ) 
     {
         String ch1 = "benoit";
         String ch2 = "   t o  in  eb      ";
         
         System.out.println( anaR(ch1,ch2) );
         
         
    }
     
     public static boolean anaR(String s1,String s2)
     {
         if ( (s1.length()==1 ) && ( s1.charAt(0) == s2.charAt(0) )  )
            return true;
         
         // Si je vois en espace ds s1 je relance sans l'espace
         for( int i = 0 ; i< s1.length() ; i++)
         {
         if ( s1.charAt(i) == ' ') { return anaR ( s1.substring(0,i) + s1.substring(i+1,s1.length() ), s2 ) ; }        
         }        
         
         // Si je vois en espace ds s2 je relance sans l'espace
         for( int i = 0 ; i< s2.length() ; i++)
         {
         if ( s2.charAt(i) == ' ') { return  anaR ( s1 , s2.substring(0,i) + s2.substring(i+1,s2.length())  ) ; }        
         }
         
         
        
         if ( s1.length() == s2.length() ) 
         {
             for( int i = 0 ; i< s1.length() ; i++)
             {
                if (s1.charAt(0) == s2.charAt(i) ) 
                {
                return anaR( s1.substring(1,s1.length()) , s2.substring(0,i) + s2.substring(i+1,s2.length())  ); 
                }
             }
         }
         
         return false;                 
     }
}