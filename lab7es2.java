import java.util.Scanner;
public class lab7es2 {
    private static long recursiveFib(int  a){
        if(a<=0)
            throw new IllegalArgumentException();
        if(a==1 || a==2)
            return 1L;
        return recursiveFib(a-2) + recursiveFib(a-1);
    }
    private static long iterativeFib(int a){
        if(a<=0)    // 1 1 2 3 5 8 13 21
            throw new IllegalArgumentException();
        long f= 1;
        if(a>=3){
            long f1=1;
            long f2=1;
            for(int j=3; j<=a; j++){
                f=f1+f2;
                f2=f1;
                f1=f;
            }
        }
        return f;
    }

    public static void main(String[] args){
        Scanner c= new Scanner(System.in);
        int b=0;
        if(args.length>1){
            System.out.println("Troppi numeri sulla riga di comando.");
            System.exit(1);
        }else if(args.length==1){
            try{
                b=Integer.parseInt(args[0]);
            }
            catch(NumberFormatException e){
                System.out.println("Parametro errato sulla riga di comando.");
                System.exit(1);
            }
        }else{
            System.out.println("Introduci numero intero positivo: ");
            while(b<=0){
                try{
                    b=Integer.parseInt(c.nextLine());  
                }
                catch(NumberFormatException e){
                    System.out.println("Parametro non rispetta le condizioni. Reinserirlo:");
                }
            }
            
        }
        long in1= System.currentTimeMillis();
        long ris1 = recursiveFib(b);
        long fin1 = System.currentTimeMillis()-in1;
        System.out.println("Risultato: " + ris1 +"\n Tempo impiegato: "+ fin1);
        long in2= System.currentTimeMillis();
        long ris2 = iterativeFib(b);
        long fin2 = System.currentTimeMillis()-in2;
        System.out.println("Risultato: " + ris2 +"\n Tempo impiegato: "+ fin2);

        c.close();
    }
    
}
