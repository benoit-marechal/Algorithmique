public class fibo1 {

    

    public static void main(String[] args) {
        int res = 1 ;
        int v = 0 ;
        int n = 6 ;
        System.out.println(v);
        for (int i=1 ; i<n ; i++)
        {
            int res2;
            res2 = res + v;
            v = res;
            res = res2;
            System.out.println(res);
        }
    }
    
}
