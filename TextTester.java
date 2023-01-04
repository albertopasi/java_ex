import java.io.*;
import java.util.*;
public class TextTester {
    public static void main(String[] args){
        try(FileReader x = new FileReader(args[0]+".txt"); 
            Scanner sc = new Scanner(x))
            {       
                Text text = new Text();
                while(sc.hasNext()){
                    text.add(sc.next());
                }
                text.sort();
                Text norep = new Text();
                String prec = "";
                while(text.size()>0){
                    String corrente = text.removeLast();
                    if(!prec.equals(corrente)){
                        norep.add(corrente);
                        prec = corrente;
                    }
                }
                for(int j=0; j<norep.size(); j++){
                    System.out.println(norep.removeLast() + " ");
                }


                
            }
        catch(IOException e){
            System.out.println("Errore, file non trovato.");
            System.exit(1);
        }
        
    }
}
