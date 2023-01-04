import java.util.*;
public class prova
{
    public static void main(String [] args)
    {
        Scanner c= new Scanner(System.in);
        do{
            System.out.println("Inserire \"q\" per terminare il programma, \"s\" per cercare il cognome di uno studente: ");
            String comando=c.next();
            if(comando.equalsIgnoreCase("q")){
                break;
            }else if(comando.equalsIgnoreCase("s")){
                System.out.println("Inserire cognome: ");
                


            }


        }while(true);
        c.close();
    }
}
   