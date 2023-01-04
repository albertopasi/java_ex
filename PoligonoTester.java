import java.io.*;
import java.util.*;

public class PoligonoTester {
    public static void main(String[] args){
        if(args.length!=1){
            System.out.println("Errore. Scrivere il nume del file input nella riga di comando.");
            System.exit(1);
        }
        SortedContainer x = new SortedContainer();
        try(FileReader in = new FileReader(args[0] + ".txt");
            Scanner sc = new Scanner(in)){
                int lineCount=0;
                while(sc.hasNextLine()){
                    lineCount++;
                    String a = sc.nextLine();
                    Scanner linescan = new Scanner(a);
                    try{
                        String iniz = linescan.next();
                        if(iniz.equals("[T]")){
                            lab9es5Triangolo tri = new lab9es5Triangolo(Integer.parseInt(linescan.next()),Integer.parseInt(linescan.next()),Integer.parseInt(linescan.next()));
                            x.add(tri);
                        }else if(iniz.equals("[R]")){
                            lab9es5Rettangolo ret = new lab9es5Rettangolo(Integer.parseInt(linescan.next()),Integer.parseInt(linescan.next()));
                            x.add(ret);
                        }else if(iniz.equals("[Q]")){
                            lab9es5Quadrato quad = new lab9es5Quadrato(Integer.parseInt(linescan.next()));
                            x.add(quad);
                        }else{
                            System.out.println("Errore riga " + lineCount + ": " + a);
                        }
                        linescan.close();
                    }
                    catch(NumberFormatException e){
                        System.out.println("Errore riga " + lineCount + ": " + a);
                    }
                    catch(NoSuchElementException e){
                        System.out.println("Errore riga " + lineCount + ": " + a);
                    }
                }
        }
        catch(IOException e){
            System.out.println("Errore. File non trovato.");
            System.exit(1);
        }
        
        System.out.println();
        System.out.println("******* Archivio ordinato di poligoni *******");
        while (!x.isEmpty())
        {   Poligono p = (Poligono)x.removeMax();
            System.out.println("Area = " + p.area() + "\t" + p);
        }




    }
}
