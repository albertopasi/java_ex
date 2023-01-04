import java.io.*;
import java.util.*;
public class PizzeriaTester {
    public static void main(String[] args){
        PizzaMap menu = new PizzaMap();
        try(FileReader read = new FileReader("pizze.txt");
            Scanner fileScan = new Scanner(read)){
                while(fileScan.hasNextLine()){
                    Scanner lineScan = new Scanner(fileScan.nextLine());
                    
                    menu.put(lineScan.next(), lineScan.nextDouble());
                }
        }
        catch(IOException e){
            System.out.println("Errore. File non trovato.");
            System.exit(1);
        }
        System.out.println("***********Contenuto mappa**********");
        System.out.println(menu.toString());

        System.out.println("\n\n*********Contenuto Mappa Ordinato per Prezzo**********");
        System.out.println(menu.printMenu());

        double prezzo= (Double) menu.get("Margherita") + (Double) menu.get("Bufala") + 2*((Double) menu.get("Prosciutto"));
        System.out.printf("Prezzo di una margherita, una bufala e due pizze al prosciutto: %.2f",prezzo);
    }
}
