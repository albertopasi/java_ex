import java.io.*;
import java.util.*;
public class SortedContainerTester {
    public static void main(String[] args){
        SortedContainer x = new SortedContainer();
        try(FileReader read= new FileReader(args[0] + ".txt");
            Scanner c=new Scanner(read) ){
                c.useDelimiter("[\\n\\r:]+");
                while(c.hasNext()){
                    Student2 a = new Student2(c.next(), c.nextInt());
                    x.add(a);
                }
        }
        catch(IOException e){
            System.out.println("File non trovato.");
            System.exit(1);
        }
        try(PrintWriter write = new PrintWriter(args[1] +".txt");){
            while(!x.isEmpty()){
                Student2 stud = (Student2) x.removeMax();
                write.println(stud.getNome() + ":" + stud.getMatricola());
            } 
        }
        catch(IOException e){
            System.out.println("Errore.");
            System.exit(1);
        }
    }
}
