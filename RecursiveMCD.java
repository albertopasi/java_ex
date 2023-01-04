public class RecursiveMCD {
    private static int mcd(int m, int n){
        if(m<=0 || n<=0)
            throw new IllegalArgumentException();
        if(n>m){
            int a=m;
            m=n;
            n=a;
        }
        if(m%n==0)
            return n;
        return mcd(n, m%n);
    }

    public static void main(String[] args){
        try{
            System.out.println(mcd(Integer.parseInt(args[0]),Integer.parseInt(args[1])));
        }
        catch(NumberFormatException e){
            System.out.println("Non hai inserito un numero intero");

        }
        catch(IllegalArgumentException e){
                    System.out.println("Numero negativo. errore");
                }
    }


}
