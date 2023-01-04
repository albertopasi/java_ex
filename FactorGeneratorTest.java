import java.util.*;
public class FactorGeneratorTest {
    public static void main(String[] args){
        Scanner c = new Scanner(System.in);
        int n=0;
        do{
            try{
                System.out.println("Inserisci numero intero maggiore di uno: ");
                n = c.nextInt();
            }
            catch(InputMismatchException e){
                c.nextLine();
            }
        }while(n<2);
        FactorGenerator x= new FactorGenerator(n);
        System.out.println("I fattori primi di " + n + " sono: ");
        while(x.hasMoreFactors()){
            System.out.println(x.nextFactor() + " ");
        }




        c.close();
    }
}
