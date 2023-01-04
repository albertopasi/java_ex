import java.util.*;
public class SquareTester {
    public static void main(String[] args){
        Scanner c =new Scanner(System.in);
        System.out.println("Inserire coordinate centro del primo quadrato e il suo lato (x y l): ");
        int x1=c.nextInt();
        int y1=c.nextInt();
        int l1=c.nextInt();
        System.out.println("Inserire coordinate centro del secondo quadrato e il suo lato (x y l): ");
        int x2=c.nextInt();
        int y2=c.nextInt();
        int l2=c.nextInt();
        Square quad1=new Square(x1,y1,l1);
        Square quad2=new Square(x2,y2,l2);
        if(quad1.getArea()<quad2.getArea()){
            System.out.println("Quadrato piu piccolo (primo quadrato): "+ quad1.toString()+ "\nQuadrato piu grande (secondo quadrato): " + quad2.toString());
        }else{
            System.out.println("Quadrato piu piccolo (secondo quadrato): "+ quad2.toString()+ "\nQuadrato piu grande (primo quadrato): " + quad1.toString());
        }
        System.out.println("Inserire larghezza e altezza del primo quadrato(l h): ");
        int wid1=c.nextInt();
        int hei1=c.nextInt();
        System.out.println("Inserire larghezza e altezza del secondo quadrato(l h): ");
        int wid2=c.nextInt();
        int hei2=c.nextInt();

        try{
            quad1.setSize(wid1, hei1);
        }
        catch(IllegalArgumentException e){
            System.out.println("Errore: i due lati non sono uguali");
            System.exit(1);
        }
        try{
            quad2.setSize(wid2, hei2);
        }
        catch(IllegalArgumentException e){
            System.out.println("Errore: i due lati non sono uguali");
            System.exit(1);
        }
        if(quad1.getArea()<quad2.getArea()){
            System.out.println("Quadrato piu piccolo (primo quadrato): "+ quad1.toString()+ "\nQuadrato piu grande (secondo quadrato): " + quad2.toString());
        }else{
            System.out.println("Quadrato piu piccolo (secondo quadrato): "+ quad2.toString()+ "\nQuadrato piu grande (primo quadrato): " + quad1.toString());
        }


        c.close();
    }
}
