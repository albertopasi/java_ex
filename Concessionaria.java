import java.io.*;
import java.util.*;
public class Concessionaria {
    public static void main(String[] args){
        CarsMultiMap auto = new CarsMultiMap();
        try(FileReader file = new FileReader("autousate.txt");
            Scanner fileScan = new Scanner(file)){      
            while(fileScan.hasNextLine()){
                Scanner lineScan=new Scanner(fileScan.nextLine());
                String nomeAuto= "";      
                while(lineScan.hasNext()){
                    nomeAuto+=lineScan.next()+" ";
                }
                double prezzo=Double.parseDouble(fileScan.nextLine());
                auto.insert(prezzo, nomeAuto);
            }
        }
        catch(IOException e){
            System.out.println("Errore. File non trovato.");
            System.exit(1);
        }

        System.out.println("Contenuto della multimappa\n" + auto.toString() +"\n");

        System.out.println("Inserire un prezzo: ");
        Scanner c=new Scanner(System.in);
   //     try{
        Double price = c.nextDouble();
   //     }
   //     catch(InputMismatchException e){
   //         System.out.println("Errore, non e' stato inserito un numero valido.");
   //     }
   //     catch(NoSuchElementException e){
   //         System.out.println("Errore, non e' stato inserito un numero.");
   //     }

        Object[] arr= auto.findAll(price);
        System.out.println("Auto proposte con un prezzo pari a " + price + ":");
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
