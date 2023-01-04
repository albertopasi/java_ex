import java.util.Scanner;
public class QuadraticEquationTester
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        System.out.println("Inserisci a b c in una riga intervellati da uno spazio: ");
        double a = console.nextDouble();
        double b = console.nextDouble();
        double c = console.nextDouble();
        QuadraticEquation equation = new QuadraticEquation(a,b,c);
        if(equation.hasSolutions()==2){
            System.out.println("Le due soluzioni dell'equazione sono: " + equation.getSolution1() + " , " + equation.getSolution2());
        }else if(equation.hasSolutions()==1){
            System.out.println("L'equazione ha una soluzione: " + equation.nonQuadraticSolution());
        }else if(equation.hasSolutions()==0){
            System.out.println("L'equazione non ha soluzioni.");
        }else if(equation.hasSolutions()==3){
            System.out.println("L'equazione ha infinite soluzioni.");
        }
        console.close();
    }
}
