import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class TrisGame {
    public static void main(String[] args){
        Scanner c= new Scanner(System.in);
        Tris board= new Tris();
        System.out.println(board.toString());
        boolean ciclo=true;
        char simbolo = 'X';
        do{
            int yon = 2;
            System.out.println("Giocatore " + (board.getCount()%2+1) + ", fai la tua mossa: ");
            try{
                int riga= c.nextInt();
                int colonna= c.nextInt();
                if(board.getCount()%2 ==1){
                    simbolo = 'O';
                }else{
                    simbolo='X';
                }
                if(!board.setCharInPosition(riga, colonna, simbolo)){
                    System.out.println("Posizione gia' occupata. Inserire una nuova posizione: ");
                }else{
                    System.out.println(board.toString());
                }
            }
            catch(InputMismatchException e){
                System.out.println("Coordinate non valide, reinserire le coordinate: ");
                c.nextLine();
            }
            catch(NoSuchElementException e){
                System.out.println("Coordinate non valide, reinserire le coordinate: ");
            }
            catch(IllegalArgumentException e){
                System.out.println("Coordinate non valide, reinserire le coordinate: ");
            }
            if(board.isWinning(simbolo)){
                System.out.println("Giocatore " + ((board.getCount()-1)%2+1) +" vince!");
                System.out.println("Volete fare un'altra partita? Inserire 0 se no, 1 se si: ");
                yon = c.nextInt();
            }else if(board.getCount()==9){
                System.out.println("Partita terminata. Pareggio");
                System.out.println("Volete fare un'altra partita? Inserire 0 se no, 1 se si: ");
                yon = c.nextInt();
            }
            if(yon==0){
                ciclo=false;
            }else if(yon==1){
                ciclo=true;
                board = new Tris();
                System.out.println(board.toString());
            }
        }while(ciclo);

        c.close();
    }
}
