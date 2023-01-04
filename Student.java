import java.util.Scanner;

public class Student{
    private String cognome;
    private int orale;
    private int scritto;

    public Student(String x1, int x2, int x3){
        cognome=x1;
        orale=x2;
        scritto=x3;
    }

    public Student(String x1){
        Scanner c = new Scanner(x1);
        cognome=c.next();
        orale=c.nextInt();
        scritto=c.nextInt();


        c.close();
    }

    public String getCognome(){
        return cognome;
    }
    public double getVoto(){
        return (orale+scritto)/2;
    }



}
