public class Tris
{   private char[][] board;
    /* costruttore che crea (ma non visualizza!)
        la scacchiera con i puntini
    */
    public Tris()
    {   board = new char[3][3];
        for(int j=0; j<3; j++){
            for(int k=0; k<3; k++){
                board[j][k]='.';
            }
        }
    }

    /* restituisce una stringa da usare per visualizzare la scacchiera
        (deve contenere anche i caratteri per andare a capo al termine
        di ognuna delle tre righe)
    */
    public String toString()
    {   String a="";
        for(int j=0; j<3; j++){
            a +="|";
            for(int k=0; k<3; k++){
                a += board[j][k];
            }
            a += "|\n";
        }

        return a;
    }

    /* imposta la posizione [row][column] al valore c;
        lancia IllegalArgumentException se le coordinate sono errate;
        restituisce false se e solo se la posizione era gia' occupata
    */
    public boolean setCharInPosition(int row, int column, char c)
    {   if((row>=0 && row<=2) && (column>=0 && column <=2)){
            if(board[row][column]=='.'){
                board[row][column]=c;
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException();
    }

    /* restituisce il carattere presente nella posizione [row][column];
        lancia IllegalArgumentException se le coordinate sono errate
    */
    public char getCharInPosition(int row, int column)
    {   if((row>=0 && row<=2) && (column>=0 && column <=2)){
            return board[row][column];
        }
        throw new IllegalArgumentException(); 
    }

    /* restituisce il numero di posizioni occupate nella scacchiera
    */
    public int getCount()
    {   int count =0;
        for(int j=0; j<3; j++){
            for(int k=0; k<3; k++){
                if(board[j][k]!='.'){
                    count++;
                }
            }
        }
        return count;
    }

    /* restituisce true se e solo se esiste nella scacchiera una
        configurazione vincente per il carattere c
    */
    public boolean isWinning(char c)
    {   for(int j=0; j<2; j++){
            if(board[j][0]==board[j][1] && board[j][1]==board[j][2] && board[j][2]==c)
                return true; 
            if(board[0][j]==board[1][j] && board[1][j]==board[2][j] && board[2][j]==c)
                return true;
        }
        if(board[0][0]==board[1][1] && board[1][1]==board[2][2] && board[2][2]==c)
            return true;
        if(board[0][2]==board[1][1] && board[1][1]==board[2][0] && board[2][0]==c)
            return true;
        return false;
    }
}